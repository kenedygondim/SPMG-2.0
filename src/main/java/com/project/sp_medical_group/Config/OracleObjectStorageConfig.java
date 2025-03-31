package com.project.sp_medical_group.Config;

import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.Region;
import com.oracle.bmc.auth.AuthenticationDetailsProvider;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;

@Configuration
public class OracleObjectStorageConfig  {
        @Bean
        public ObjectStorage objectStorage() throws IOException {
                ConfigFileReader.ConfigFile configFile = ConfigFileReader.parseDefault();
                AuthenticationDetailsProvider provider = new ConfigFileAuthenticationDetailsProvider(configFile);
                
                return ObjectStorageClient.builder().region(Region.SA_SAOPAULO_1).build(provider);
        }
}
