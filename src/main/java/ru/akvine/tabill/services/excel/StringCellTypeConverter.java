package ru.akvine.tabill.services.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;

@Service
public class StringCellTypeConverter implements CellTypeConverter {
    @Override
    public String convert(Cell cell) {
        return cell.getStringCellValue();
    }

    @Override
    public CellType getType() {
        return CellType.STRING;
    }
}
