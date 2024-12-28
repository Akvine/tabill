package ru.akvine.tabill.services.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;

@Service
public class BooleanCellTypeConverter implements CellTypeConverter {
    @Override
    public String convert(Cell cell) {
        return Boolean.toString(cell.getBooleanCellValue());
    }

    @Override
    public CellType getType() {
        return CellType.BOOLEAN;
    }
}
