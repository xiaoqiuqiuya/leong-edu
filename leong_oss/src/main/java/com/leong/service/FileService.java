package com.leong.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadImage(MultipartFile file);
}
