package com.bestbuyapp.Services;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {
    @Test
    public void getServices(){
        Response response;
        response =  given()
                .when()
                .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
