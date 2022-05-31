package com.bestbuyapp.products;

import com.bestbuyapp.model.productPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {
    Response response;
    @Test
    public void updateProduct(){
        productPojo pojoClass = new productPojo();
        pojoClass.setPrice(1000);

        response = given()
       .header("Content-Type", "application/json")
                .body(pojoClass)
                .when()
                .patch("/products/127687");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
