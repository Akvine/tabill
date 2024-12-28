package ru.akvine.tabill.services;

import org.springframework.web.multipart.MultipartFile;

public interface ConvertService {
    byte[] convert(MultipartFile file,
                   String tableName,
                   String separator);
}
