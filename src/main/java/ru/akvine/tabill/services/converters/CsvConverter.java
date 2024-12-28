package ru.akvine.tabill.services.converters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.exceptions.ConvertException;
import ru.akvine.tabill.exceptions.WriteBytesToStreamException;
import ru.akvine.tabill.services.dto.ConvertParams;
import ru.akvine.tabill.utils.StringHelper;

import java.io.*;

@Service
@Slf4j
public class CsvConverter extends AbstractConverter {
    @Override
    public byte[] convert(InputStream inputStream, ConvertParams params) {
        super.convert(inputStream, params);
        StringBuilder sb = new StringBuilder();

        String line;
        boolean firstLineSkipped = false;

        String separator = params.getSeparator();
        String tableName = params.getTableName();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = reader.readLine()) != null) {
                if (!firstLineSkipped) {
                    firstLineSkipped = true;
                } else {
                    String[] valuesFromCsv = line.split(separator);
                    sb
                            .append(INSERT_INTO_TEMPLATE)
                            .append(tableName)
                            .append(VALUES_TEMPLATE)
                            .append(to(valuesFromCsv)).append("\n");
                }
            }
        } catch (IOException exception) {
            String errorMessage = String.format(
                    "Error while convert file to csv. Message = [%s]",
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
        return Extension.CSV;
    }

    private String to(String[] values) {
        StringBuilder sb = new StringBuilder();

        int lastIndex = values.length - 1;

        for (int i = 0; i < values.length; ++i) {
            sb.append("\'").append(values[i]).append("\'");
            if (i == lastIndex) {
                sb.append(CLOSE_TEMPLATE);
            } else {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
