package ru.akvine.tabill.rest.converter;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.akvine.tabill.services.dto.ConvertParams;
import ru.akvine.tabill.utils.Asserts;

@Component
public class TabillConverter {
    @Value("${sql.mime.type}")
    private String defaultSqlMimeType;
    @Value("${skip.lines.count}")
    private int defaultSkipLinesCount;
    @Value("${csv.default.separator}")
    private String defaultCsvSeparator;

    public ConvertParams convertParams(String tableName,
                                       String separator,
                                       Integer skipLinesCount) {
        Asserts.isNotNull(tableName, "tableName is null");
        return new ConvertParams()
                .setTableName(tableName)
                .setSeparator(StringUtils.isBlank(separator) ? defaultCsvSeparator : separator)
                .setSkipLinesCount(skipLinesCount == null ? defaultSkipLinesCount : skipLinesCount);
    }

    public ResponseEntity<?> convertToResponse(byte[] sqlFile) {
        Asserts.isNotNull(sqlFile, "sqlFile is null");
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, defaultSqlMimeType)
                .body(sqlFile);
    }
}
