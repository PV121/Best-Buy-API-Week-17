package com.bestbuyapp.Categories;

import com.bestbuyapp.model.CategoriesPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {
    Response response;
    @Test
    public void craeteCategories(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("adi");
        categoriesPojo.setId("25");
        response = given()
                .header("content-type","application/json")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
