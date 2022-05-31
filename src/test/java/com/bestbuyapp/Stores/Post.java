package com.bestbuyapp.Stores;

import com.bestbuyapp.model.StoresPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {
    @Test
    public void createStore(){

        StoresPojo storesPojo =  new StoresPojo();
        storesPojo.setName("BigBox");
        storesPojo.setAddress("dfgdtd road");
        storesPojo.setAddress2("");
        storesPojo.setCity("florida");
        storesPojo.setState("florida");
        storesPojo.setZip("678904");
        storesPojo.setLat(66.789);
        storesPojo.setLng(77.789);
        storesPojo.setHours("Mon:6-7");
        storesPojo.setServices("");
        Response response;
        response = given()
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
