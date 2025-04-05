package com.project.sp_medical_group.Repositories;

import java.io.FileNotFoundException;


public interface OCIObjectStorageRepository {
    public abstract String uploadFile() throws FileNotFoundException;
}
