package hello.springmvc.deserialize;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import hello.springmvc.basic.deserialize.GenericResponse;
import hello.springmvc.basic.deserialize.SocialAccountResponse;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

class DeserializeTest extends ApiTest {

	@DisplayName("JSON을 Object로 변환한다")
	@Test
	void json_to_object() {
		String requestBody = "{\n"
			+ "  \"status\": true,\n"
			+ "  \"code\": 200,\n"
			+ "  \"data\": {\n"
			+ "    \"id\": \"123456\",\n"
			+ "    \"profileUrl\": \"https://www.facebook.com/123456\"\n"
			+ "  }\n"
			+ "}";

		ExtractableResponse<Response> response = RestAssured.given().log().all()
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body(requestBody)
			.when()
			.post("/api/social")
			.then()
			.log().all()
			.extract();

		assertThat(response.statusCode()).isEqualTo(201);
		assertThat(response.jsonPath().getBoolean("status")).isTrue();
		assertThat(response.jsonPath().getInt("code")).isEqualTo(200);
	}
}
