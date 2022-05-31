package com.bestbuyapp.products;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {
    Response response;

    @Test
    public void getUser() {
        response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
