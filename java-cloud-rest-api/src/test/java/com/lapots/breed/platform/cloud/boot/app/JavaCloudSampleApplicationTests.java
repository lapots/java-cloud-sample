package com.lapots.breed.platform.cloud.boot.app;

import com.lapots.breed.platform.cloud.boot.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaCloudSampleApplicationTests {

	@MockBean
	private PersonRepository personRepository;

	@Test
	public void contextLoads() {
	}

}
