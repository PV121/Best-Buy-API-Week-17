package com.bestbuyapp.products;

import com.bestbuyapp.model.productPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {

    Response response;
    @Test
    public void addProduct(){
        productPojo pojoClass = new productPojo();
        pojoClass.setName("anna");
        pojoClass.setType("shinar");
        pojoClass.setPrice(2300);
        pojoClass.setShipping(0);
        pojoClass.setUpc("string");
        pojoClass.setDescription("nothing");
        pojoClass.setManufacturer("string");
        pojoClass.setModel("y978");
        pojoClass.setUrl("www.string");
        pojoClass.setImage(".str");

        response=given()
                .header("Content-Type","application/json")
                .body(pojoClass)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();




    }
}
