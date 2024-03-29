package com.petstoreapp.petapp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "file")
public class FileStoragePropertie {
    private String uploadDir;
}
