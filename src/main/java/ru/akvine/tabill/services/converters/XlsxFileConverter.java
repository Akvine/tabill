package ru.akvine.tabill.services.converters;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.managers.CellTypeConvertersManager;
import ru.akvine.tabill.services.dto.ConvertParams;

import java.io.InputStream;

@Service
public class XlsxFileConverter extends XlsFileConverter {

    @Autowired
    public XlsxFileConverter(CellTypeConvertersManager cellTypeConvertersManager) {
        super(cellTypeConvertersManager);
    }

    @Nullable
    @Override
    public byte[] convert(InputStream inputStream, ConvertParams params) {
        return super.convert(inputStream, params);
    }

    @Override
    public Extension getType() {
        return Extension.XSLX;
    }
}
