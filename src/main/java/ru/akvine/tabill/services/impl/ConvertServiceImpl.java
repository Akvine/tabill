package ru.akvine.tabill.services.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.enums.Extension;
import ru.akvine.tabill.managers.ConvertersManager;
import ru.akvine.tabill.services.ConvertService;
import ru.akvine.tabill.services.FileService;
import ru.akvine.tabill.services.dto.ConvertParams;

@Service
@RequiredArgsConstructor
public class ConvertServiceImpl implements ConvertService {
    private final ConvertersManager convertersManager;
    private final FileService fileService;

    @Override
    public byte[] convert(MultipartFile file,
                          ConvertParams params) {
        String extension = FilenameUtils.getExtension(file
                .getOriginalFilename());
        Extension fromString = Extension.from(extension);
        return convertersManager
                .getByExtension(fromString)
                .convert(
                        fileService.getInputStream(file),
                        params
                );
    }
}
