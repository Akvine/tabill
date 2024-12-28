package ru.akvine.tabill.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/tabill")
public interface TabillControllerMeta {
    @GetMapping(value = "/convert")
    ResponseEntity<?> convert(@RequestParam("file") MultipartFile file,
                              @RequestParam("tableName") String tableName,
                              @RequestParam(value = "separator", required = false) String separator);

}
