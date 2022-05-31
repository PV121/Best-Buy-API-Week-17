package com.bestbuyapp.Services;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete extends TestBase {
    @Test
    public void deleteServices(){
        Response response;
        response = given()
                .when()
                .delete("/services/24");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
