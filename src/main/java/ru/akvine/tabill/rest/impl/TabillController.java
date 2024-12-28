package ru.akvine.tabill.rest.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.rest.TabillControllerMeta;
import ru.akvine.tabill.services.ConvertService;

@RestController
@RequiredArgsConstructor
public class TabillController implements TabillControllerMeta {
    private static final String DEFAULT_SEPARATOR = ";";

    private final ConvertService convertService;

    @Override
    public ResponseEntity<?> convert(@RequestParam("file") MultipartFile file,
                                     @RequestParam("tableName") String tableName,
                                     @RequestParam(value = "separator", required = false) String separator) {
        if (separator == null) {
            separator = DEFAULT_SEPARATOR;
        }

        byte[] sqlFile = convertService.convert(file, tableName, separator);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/sql")
                .body(sqlFile);
    }
}
