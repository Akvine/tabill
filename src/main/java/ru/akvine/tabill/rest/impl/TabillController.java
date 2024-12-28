package ru.akvine.tabill.rest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.rest.TabillControllerMeta;
import ru.akvine.tabill.rest.converter.TabillConverter;
import ru.akvine.tabill.services.ConvertService;
import ru.akvine.tabill.services.dto.ConvertParams;

@RestController
@RequiredArgsConstructor
public class TabillController implements TabillControllerMeta {
    private final TabillConverter tabillConverter;
    private final ConvertService convertService;

    @Override
    public ResponseEntity<?> convert(@RequestParam("file") MultipartFile file,
                                     @RequestParam("tableName") String tableName,
                                     @RequestParam(value = "separator", required = false) String separator,
                                     @RequestParam(value = "skipLinesCount", required = false) Integer skipLinesCount) {
        ConvertParams params = tabillConverter.convertParams(tableName, separator, skipLinesCount);
        byte[] sqlFile = convertService.convert(file, params);
        return tabillConverter.convertToResponse(sqlFile);
    }
}
