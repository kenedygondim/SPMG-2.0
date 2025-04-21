package com.project.sp_medical_group.Services.Oracle;

import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;
import com.oracle.bmc.objectstorage.requests.PutObjectRequest;

import com.oracle.bmc.objectstorage.responses.PutObjectResponse;
import com.project.sp_medical_group.Repositories.OCIObjectStorageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class OCIObjectStorageService implements OCIObjectStorageRepository {

     private final ObjectStorage objectStorage;

     public OCIObjectStorageService(@Autowired ObjectStorage objectStorage)
     {
         this.objectStorage = objectStorage;
     }


     public String uploadFile (MultipartFile fileSent, String fileName) throws IOException {
         var putRequest = PutObjectRequest.builder()
                 .bucketName("sp-medical-group")
                 .namespaceName(objectStorage.getNamespace(GetNamespaceRequest.builder().build()).getValue())
                 .objectName("profile-pictures/" + fileName)
                 .contentLength(fileSent.getSize())
                 .putObjectBody(fileSent.getInputStream())
                 .build();

         PutObjectResponse response = objectStorage.putObject(putRequest);

         System.out.println("Upload completo! ETag: " + response.getETag());

         return response.getETag();
     }


}