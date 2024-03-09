package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.http.protocol.ResponseServer;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserTests {

    User payload;
    Faker faker;
    @BeforeTest
    public void getData(){
        payload= new User();
         faker= new Faker();
        payload.setFirstname(faker.name().firstName());
        payload.setLastname(faker.name().lastName());
        payload.setEmail(faker.internet().emailAddress());
        payload.setPassword(faker.internet().password());
        payload.setUsername(faker.name().username());
        payload.setId(faker.idNumber().hashCode());
    }

    @Test(priority = 1)
    public void testCreateUser(){
      Response response= UserEndPoints.createUser(payload);
      response.then().log().all();
     Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 2)
    public void testGetUser(){
      Response response= UserEndPoints.getUser(this.payload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testUpdateUser(){
        payload.setFirstname(faker.name().firstName());
        payload.setLastname(faker.name().lastName());
        payload.setEmail(faker.internet().emailAddress());
        Response response= UserEndPoints.upadteUser(payload,payload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUser(){
        Response response =UserEndPoints.deleteUser(payload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
