package ru.akvine.tabill.rest.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.akvine.tabill.constants.ErrorCodes;
import ru.akvine.tabill.exceptions.ValidationException;
import ru.akvine.tabill.services.FileService;

@Component
@RequiredArgsConstructor
public class TabillValidator {
    private final FileService fileService;

    public void verifyRequestParams(MultipartFile file) {
        if (file == null ||
                fileService.getInputStream(file) == null ||
                fileService.getBytes(file).length == 0) {
            throw new ValidationException(
                    ErrorCodes.Validation.FILE_NOT_UPLOADED_ERROR,
                    "File is not uploaded!"
            );
        }
    }
}
