package com.bestbuyapp.products;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

//9999681
public class Delete extends TestBase {
    @Test
    public void deleteID(){
        Response response;
        response = given()
                .when()
                .delete("/products/9999681");//9999682 use this id for delete
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
