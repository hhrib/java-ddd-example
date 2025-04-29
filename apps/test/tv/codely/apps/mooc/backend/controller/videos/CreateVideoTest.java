package tv.codely.apps.mooc.backend.controller.videos;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateVideoTest {

	@LocalServerPort
	int port;

	@BeforeAll
	static void setupRestAssured() {
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	public void shouldCreateVideo() {
		String requestBody = "{\"title\": \"The best course\", \"url\": \"http://codely.com\", \"text\": \"Hello video\"}";
		//		RestAssured.port = 8030;
		//		RestAssured.basePath = "/videos";
		given()
			.contentType(ContentType.JSON)
			.port(port)
			.body(requestBody)
			.pathParam("id", "f81d4fae-7dec-11d0-a765-00a0c91e6bf6")
			.when()
			.put("/videos/{id}")
			.then()
			.statusCode(HttpStatus.CREATED.value())
			.body(equalTo(""));
	}
}
