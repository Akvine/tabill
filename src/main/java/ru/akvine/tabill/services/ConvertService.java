package ru.akvine.tabill.services;

import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.services.dto.ConvertParams;

public interface ConvertService {
    byte[] convert(MultipartFile file,
                   ConvertParams params);
}
