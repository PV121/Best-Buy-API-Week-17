package com.bestbuyapp.Utilities;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetHealthCheck extends TestBase {
    @Test
    public void monitoringHealthInfo(){
        Response response;
        response = given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
