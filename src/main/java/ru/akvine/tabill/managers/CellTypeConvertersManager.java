package ru.akvine.tabill.managers;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.CellType;
import ru.akvine.tabill.exceptions.FileExtensionNotSupportedException;
import ru.akvine.tabill.services.excel.CellTypeConverter;

import java.util.Map;

@AllArgsConstructor
public class CellTypeConvertersManager {
    private final Map<CellType, CellTypeConverter> converters;

    public CellTypeConverter getByExtension(CellType cellType) {
        if (converters.containsKey(cellType)) {
            return converters.get(cellType);
        } else {
            String errorMessage = String.format(
                    "Cell type = [%s] is not supported by app",
                    cellType
            );
            throw new FileExtensionNotSupportedException(errorMessage);
        }
    }
}
