package com.bestbuyapp.Stores;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteByID extends TestBase {
    @Test
    public void deleteStores(){
        Response response;
        response = given()
                .when()
                .delete("/stores/6");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
