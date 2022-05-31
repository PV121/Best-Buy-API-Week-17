package com.bestbuyapp.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
// 6,

public class Assert {
    static ValidatableResponse response;

    @Before
    public void inIt() {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


    //Verify the if the stores total is equal to 1565
    @Test
    public void verifyTotal() {
int total = response.extract().path("total");
        System.out.println("Total of the stores " + total);
        org.junit.Assert.assertEquals(1565,total);

    }
    //        2. Verify the if the stores of limit is equal to 10
    @Test
    public void verifyLimit(){
        int limit = response.extract().path("limit");
        System.out.println("Total of the stores " + limit);
        org.junit.Assert.assertEquals("limit is not found",limit,10);
    }
    //        3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void checkName(){
     String name =  response.extract().path("data[1].name");
      //List<HashMap<String,?>> names = response.extract().path("data.findAll{it.name=='Inver Grove Heights'}.name");
        System.out.println(name);
        org.junit.Assert.assertEquals("Inver Grove Heights not found","Inver Grove Heights",name);
    }
    //        4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
    @Test
    public void checkMultipleNames(){
        List<String> names = response.extract().path("data[2,3,4].name");
        System.out.println(names);
        List<String> expected = new ArrayList<>();
        expected.add("Roseville");
        expected.add("Burnsville");
        expected.add("Maplewood");
        org.junit.Assert.assertEquals("Roseville, Burnsville, Maplewood not found",expected,names);

    }
    //        5. Verify the storied=7 inside storeservices of the third store of second services
@Test
    public void verifyStoreID(){
     int id = response.extract().path("data[2].services[3].storeservices.storeId");
    System.out.println(id);
    org.junit.Assert.assertEquals("id is not found",7,id);
}
//        6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
    @Test
    public void createdAt(){
  // List<HashMap<String,?>> createdAt = response.extract().path("data[2].services[*].storeservices.createdAt");
   //List<HashMap<String,?>> createdAt = response.extract().path("data[2].services[*].createdAt");

   List<HashMap<String,Object>> createdAt = response.extract().path("data.findAll{it.name=='Roseville'}.storeservices.createdAt");
        System.out.println("createdAt of Roseville " + createdAt);
//data[2].services[*].createdAt
    }
    //        7. Verify the state = MN of forth store
    @Test
    public void findState(){
     String state =   response.extract().path("data[4].state");
        System.out.println("fourth stote state is : " + state);
        org.junit.Assert.assertEquals("state is not found",state,"MN");
    }
    //        8. Verify the store name = Rochester of 9th store
    @Test
    public void findStoreName(){
        String storeName = response.extract().path("data[8].name");
        System.out.println("store name of 9th store : " + storeName);
        org.junit.Assert.assertEquals("store name not found","Rochester",storeName);

    }
    //        9. Verify the storeId = 11 for the 6th store
    @Test
    public void verifyStoreId(){
        int storeId = response.extract().path("data[5].id");
        System.out.println("store Id of 6th store : " + storeId);
        org.junit.Assert.assertEquals("store id not found",11,storeId);

    }
    //        10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void verifyServiceID(){
   int sId = response.extract().path("data[7].services[3].storeservices.serviceId");
        System.out.println("serviceID of 7th store=>4th service : " + sId);
        org.junit.Assert.assertEquals("serviceId not found",4 ,sId);
}

}