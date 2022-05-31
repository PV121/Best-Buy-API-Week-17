package com.bestbuyapp.products;

import com.bestbuyapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetByID extends TestBase {
 Response response;
 @Test
 public void getByID(){
     response = given()
             .when()
             .get("/products/127687");//127687,9999682
     response.then().statusCode(200);
     response.prettyPrint();
 }
}
