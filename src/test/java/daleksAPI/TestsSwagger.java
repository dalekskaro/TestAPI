package daleksAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestsSwagger {
    private final static String URL =  "https://petstore.swagger.io/";

    @Test
    public void getUserByNameTest() {
        RestAssured.
                when()
                .get("https://petstore.swagger.io/v2/user/" + "string")
                .then().log().body()
                .assertThat().statusCode(200)
                .and().body("email", equalTo("string"));
        RestAssured.
                when()
                .get("https://petstore.swagger.io/v2/user/" + "ivan")
                .then().log().body()
                .assertThat().statusCode(404);
    }

    @Test
    public void postNewUserTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 394);
        map.put("username", "123Solas123");
        map.put("firstName", "Solas");
        map.put("lastName", "Fenharel");
        map.put("email", "dreadwolf@mail.com");
        map.put("password", "ilovetea");
        map.put("phone", "88005553535");
        map.put("userStatus", 1);

        JSONObject request = new JSONObject(map);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .header("accept", "application/json")
                .body(request.toJSONString())
        .when()
                .post("https://petstore.swagger.io/v2/user")
        .then().log().all()
        .assertThat().statusCode(200);
    }

    @Test
    public void putUpdateUserTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 999);
        map.put("username", "TheBestWolf");
        map.put("firstName", "Solas");
        map.put("lastName", "Fenharel");
        map.put("email", "dw@tedas.com");
        map.put("password", "ilovetea");
        map.put("phone", "8800");
        map.put("userStatus", 1);

        JSONObject request = new JSONObject(map);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .header("accept", "application/json")
                .body(request.toJSONString())
        .when()
                .put("https://petstore.swagger.io/v2/user/Solas")
        .then().log().body()
        .assertThat().statusCode(200);
    }

    @Test
    public void deleteUser() {
        RestAssured
                .given()
                .when()
                .delete("https://petstore.swagger.io/v2/user/TheBestWolf")
                .then().log().body()
                .assertThat().statusCode(200);
    }

}
