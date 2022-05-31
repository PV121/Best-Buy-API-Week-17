package com.bestbuyapp.Stores;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetByID extends TestBase {
    @Test
    public void getByID(){
        Response response;
        response = given()
                .when()
                .get("/stores/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
