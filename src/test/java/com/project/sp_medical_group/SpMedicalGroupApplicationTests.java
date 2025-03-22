package com.project.sp_medical_group;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "spring.main.web-application-type=reactive")
@ActiveProfiles("test")
class SpMedicalGroupApplicationTests {
	@Test
	void contextLoads() {
	}

}
