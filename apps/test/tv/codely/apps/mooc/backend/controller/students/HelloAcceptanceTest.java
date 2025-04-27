package tv.codely.apps.mooc.backend.controller.students;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloAcceptanceTest {

	@LocalServerPort
	int port;

	@BeforeAll
	static void setupRestAssured() {
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	void shouldReturnHelloWorld() {
		given().port(port).when().get("/api/hello").then().statusCode(200).body(equalTo("Hello world!"));
	}
}
