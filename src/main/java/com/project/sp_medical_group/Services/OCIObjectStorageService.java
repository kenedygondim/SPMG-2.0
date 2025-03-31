package com.project.sp_medical_group.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetNamespaceRequest;
import com.oracle.bmc.objectstorage.responses.GetNamespaceResponse;

public class OCIObjectStorageService {

    private final ObjectStorageClient objectStorageClient;

    @Value("${oracle.cloud.namespace}")
    private final String namespace;

    @Value("${oracle.cloud.bucket.name}")
    private final String bucketName;


    public OCIObjectStorageService(
            @Autowired ObjectStorageClient objectStorageClient,
            @Value("${oracle.cloud.namespace}") String namespace,
            @Value("${oracle.cloud.bucket.name}") String bucketName)
             throws IOException {
        this.namespace = namespace;
        this.bucketName = bucketName;
        this.objectStorageClient = objectStorageClient;
    }

    public Void getNamespaceResponse() {
        GetNamespaceResponse namespaceResponse =  objectStorageClient.getNamespace(GetNamespaceRequest.builder().build());
        String namespaceName = namespaceResponse.getValue();
        System.out.println("Using namespace: " + namespaceName);
        return null;
    }
    
}