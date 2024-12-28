package ru.akvine.tabill.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.exceptions.ExtractInputStreamException;
import ru.akvine.tabill.services.FileService;
import ru.akvine.tabill.utils.Asserts;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public InputStream getInputStream(MultipartFile file) {
        Asserts.isNotNull(file, "file is null");

        try {
            return file.getInputStream();
        } catch (IOException exception) {
            String errorMessage = String.format(
                    "Error while extract input stream from file = [%s]",
                    exception.getMessage());
            throw new ExtractInputStreamException(errorMessage);
        }
    }
}
