import java.lang.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APItest {
    @Test
    void test1(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("Response: "+response.asString());
        System.out.println("Status code: "+response.statusCode());
        System.out.println("Body: "+response.getBody().asString());
        System.out.println("Time taken: "+response.getTime());

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);

    }
    @Test
    void test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200);
    }
}
