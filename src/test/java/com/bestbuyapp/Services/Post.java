package com.bestbuyapp.Services;

import com.bestbuyapp.model.ServicesPojo;
import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {
    Response response;
    @Test
    public void craeteServices(){

      ServicesPojo servicesPojo =  new ServicesPojo();
      servicesPojo.setName("aliah");
        response = given()
                .header("content-type","application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();
// id = 23
    }
}
