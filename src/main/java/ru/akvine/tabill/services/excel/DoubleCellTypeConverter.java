package ru.akvine.tabill.services.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;

@Service
public class DoubleCellTypeConverter implements CellTypeConverter {
    @Override
    public String convert(Cell cell) {
        return Double.toString(cell.getNumericCellValue());
    }

    @Override
    public CellType getType() {
        return CellType.NUMERIC;
    }
}
