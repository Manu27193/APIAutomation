package api.test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTests {
   public User payload;
    @BeforeTest
    public void getData(){
        payload= new User();

    }

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public  void testPostUsers(String UserID, String Username, String FirstName, String lastName, String Email, String Password, String phone){
        payload = new User();
        payload.setFirstname(FirstName);
        payload.setLastname(lastName);
        payload.setEmail(Email);
        payload.setPassword(Password);
        payload.setUsername(Username);
        payload.setId(Integer.parseInt(UserID));

     Response response= UserEndPoints.createUser(payload);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "userNames",dataProviderClass = DataProviders.class)
    public void deleteUsersCreated(String username) {
       Response response= UserEndPoints.deleteUser(username);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
