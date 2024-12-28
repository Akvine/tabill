package ru.akvine.tabill.services.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public interface CellTypeConverter {
    String convert(Cell cell);

    CellType getType();
}
