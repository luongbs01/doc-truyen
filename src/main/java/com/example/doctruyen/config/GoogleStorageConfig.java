package com.example.doctruyen.config;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
public class GoogleStorageConfig {

    @Bean
    public Storage setupStorage() {
        ClassPathResource serviceAccount = new ClassPathResource("doc-truyen-firebase-adminsdk.json");
        try {
            Credentials credentials = GoogleCredentials.fromStream(serviceAccount.getInputStream());
            return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
