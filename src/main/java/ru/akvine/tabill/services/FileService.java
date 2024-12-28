package ru.akvine.tabill.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {

    InputStream getInputStream(MultipartFile file);
}
