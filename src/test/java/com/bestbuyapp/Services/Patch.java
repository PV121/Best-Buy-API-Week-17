package com.bestbuyapp.Services;

import com.bestbuyapp.model.ServicesPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {
    @Test
    public void updateServices(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("adi");

        Response response;
        response = given()
                .header("content-type","application/json")
                .body(servicesPojo)
                .when()
                .patch("/services/23");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
