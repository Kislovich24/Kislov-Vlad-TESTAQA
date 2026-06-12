package Postman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @BeforeAll
    public static void setUp() {
        // Задаем базовый URL для эхо-сервера Postman
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {
        String myText = "Hello Aston";

        given()
                .contentType(ContentType.TEXT)
                .body(myText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(myText));
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        String jsonBody = "{\"key\": \"value\"}";

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(jsonBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("value"));
    }

    @Test
    public void testPatchRequest() {
        String jsonBody = "{\"status\": \"updated\"}";

        given()
                .contentType(io.restassured.http.ContentType.JSON)
                .body(jsonBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.status", equalTo("updated"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}