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
			.port(8030)
			.body(requestBody)
			.pathParam("id", "fdfsdfdsfdsf")
			.when()
			.put("/videos/{id}")
			.then()
			.statusCode(HttpStatus.CREATED.value())
			.body(equalTo(""));
	}
	//	@Test
	//	void shouldReturnHelloWorld() {
	//		given()
	//			.port(port)
	//			.contentType(ContentType.JSON)
	//			.body("{\"title\": \"The best course\", \"url\": \"http>//codely.com\", \"text\": \"Hello video!\"}")
	//			.when()
	//			.post("/videos/1aab45ba-3c7a-4344-8936-78466eca77fa")
	//			.then()
	//			.statusCode(201);
	//	}
}
