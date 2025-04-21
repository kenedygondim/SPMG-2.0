package com.project.sp_medical_group.Repositories;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface OCIObjectStorageRepository {
    public abstract String uploadFile(MultipartFile fileSent, String fileName) throws IOException;
}
