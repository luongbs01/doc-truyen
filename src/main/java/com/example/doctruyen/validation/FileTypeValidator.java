package com.example.doctruyen.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class FileTypeValidator implements ConstraintValidator<AllowedFileTypes, MultipartFile> {

    private List<String> allowTypes;

    @Override
    public void initialize(AllowedFileTypes constraintAnnotation) {
        allowTypes = Arrays.asList(constraintAnnotation.allowedTypes());
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return true;
        }

        String contentType = file.getContentType();

        if (contentType == null || !allowTypes.contains(contentType)) {
            return false;
        }
        return true;
    }
}
