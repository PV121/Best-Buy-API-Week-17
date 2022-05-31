package com.bestbuyapp.Stores;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PathchByID extends TestBase {
    @Test
    public void updateStores(){
        Response response;
        response = given()
                .when()
                .patch("/stores/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
