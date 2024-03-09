package api.endpoints;

import api.payloads.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

   public static Response createUser(User payload) {
      Response response= given()
               .contentType(ContentType.JSON)
               .accept(ContentType.JSON)
               .body(payload)
               .when().post(Routes.PostUrl);
      return response;
    }

    public static Response getUser(String username) {
        Response response= given()
                .pathParam("username", username)
                .when().get(Routes.GetUrl);
        return response;
    }

    public static Response upadteUser(User payload, String username) {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username", username)
                .when().put(Routes.UpdateUrl);
        return response;
    }

    public static Response deleteUser(String username) {
        Response response= given()
                .pathParam("username", username)
                .when().delete(Routes.DeleteUrl);
        return response;
    }

}
