package com.test.gerenciamento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(locations = "classpath:test.properties")
@SpringBootTest(classes = GerenciamentoApplicationTests.class)
class GerenciamentoApplicationTests {

	@Test
	void contextLoads() {
	}

}
