package ru.akvine.tabill.services.converters;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.exceptions.ConvertException;
import ru.akvine.tabill.exceptions.WriteBytesToStreamException;
import ru.akvine.tabill.managers.CellTypeConvertersManager;
import ru.akvine.tabill.services.dto.ConvertParams;
import ru.akvine.tabill.utils.StringHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class XlsFileConverter extends AbstractConverter {
    private final CellTypeConvertersManager cellTypeConvertersManager;

    @Nullable
    @Override
    public byte[] convert(InputStream inputStream, ConvertParams params) {
        super.convert(inputStream, params);
        StringBuilder sb = new StringBuilder();

        String tableName = params.getTableName();
        int skipLinesCount = params.getSkipLinesCount();
        int skipped = 0;

        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (skipped < skipLinesCount) {
                    skipped += 1;
                    continue;
                }

                List<String> valuesFromExcel = new ArrayList<>();
                for (Cell cell : row) {
                    String valueFromCell = cellTypeConvertersManager
                            .getByExtension(cell.getCellType())
                            .convert(cell);
                    valuesFromExcel.add(valueFromCell);
                }

                sb
                        .append(INSERT_INTO_TEMPLATE)
                        .append(tableName)
                        .append(VALUES_TEMPLATE)
                        .append(to(valuesFromExcel)).append("\n");
            }
        } catch (IOException exception) {
            String errorMessage = String.format(
                    "Error while convert file from excel. Message = [%s]",
                    exception.getMessage());
            throw new ConvertException(errorMessage);
        }

        byte[] bytes = StringHelper.removeLastSymbol(sb.toString()).getBytes();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length)) {
            outputStream.write(bytes);
            return outputStream.toByteArray();
        } catch (IOException exception) {
            log.error("Can't write bytes to output stream. Message = [{}]", exception.getMessage());
            throw new WriteBytesToStreamException(exception.getMessage());
        }
    }

    @Override
    public Extension getType() {
        return Extension.XLS;
    }

    // TODO: вынести в отдельны класс в AbstractConverter
    private String to(List<String> values) {
        StringBuilder sb = new StringBuilder();

        int lastIndex = values.size() - 1;

        for (int i = 0; i < values.size(); ++i) {
            sb.append("\'").append(values.get(i)).append("\'");
            if (i == lastIndex) {
                sb.append(CLOSE_TEMPLATE);
            } else {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
