package com.bestbuyapp.Categories;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Delete extends TestBase {
    @Test
    public void deleteCategories(){
        Response response;
        response = given()
                .when()
                .delete("/categories/22");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
