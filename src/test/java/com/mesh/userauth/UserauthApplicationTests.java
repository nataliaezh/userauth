package com.mesh.userauth;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserauthApplicationTests {
	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void accessApplication() {
		System.out.println(port);
	}
	@Test
	void trueAssumption() {
		assumeTrue(5 > 1);
		assertEquals(5 + 2, 7);
	}

	@Test
	void falseAssumption() {
		assumeFalse(5 < 1);
		assertEquals(5 + 2, 7);
	}

	@Test
	void assumptionThat() {
		String someString = "Just a string";
		assumingThat(
				someString.equals("Just a string"),
				() -> assertEquals(2 + 2, 4)
		);
	}
}



