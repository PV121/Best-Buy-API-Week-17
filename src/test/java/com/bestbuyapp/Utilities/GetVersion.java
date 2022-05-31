package com.bestbuyapp.Utilities;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetVersion extends TestBase {
    @Test
    public void monitoringVersion(){
        Response response;
        response =  given()
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
