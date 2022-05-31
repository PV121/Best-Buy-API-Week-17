package com.bestbuyapp.Categories;

import com.bestbuyapp.model.CategoriesPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Patch extends TestBase {
    @Test
    public void updateCategories(){
        CategoriesPojo categoriesPojo =  new CategoriesPojo();
        categoriesPojo.setName("aliah");
        Response response;
        response =  given()
                .header("content-type","application/json")
                .body(categoriesPojo)
                .when()
                .patch("/categories/23");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
