package com.example.doctruyen.service;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GoogleCloudStorageService implements FileService {

    public static final String BUCKET_NAME = "doc-truyen-398103.appspot.com";
    public static final String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/doc-truyen-398103.appspot.com/o/%s?alt=media";
    private final Storage storage;

    @Override
    public String uploadFile(MultipartFile file) {
        String filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String filename = UUID.randomUUID() + "." + filenameExtension;

        BlobId blobId = BlobId.of(BUCKET_NAME, filename);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        try {
            storage.create(blobInfo, file.getBytes());
            return String.format(DOWNLOAD_URL, URLEncoder.encode(filename, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
