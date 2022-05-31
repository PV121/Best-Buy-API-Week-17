package com.bestbuyapp;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

//10,15,16,19



public class extraction {
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

    //1. Extract the limit
    @Test
    public void extractLimit() {
        int limit = response.extract().path("limit");
        System.out.println("1) Total limit of the stores " + limit);
    }

    //2. Extract the total
    @Test
    public void extractTotal() {
        int total = response.extract().path("total");
        System.out.println("2) Total of the stores " + total);
    }

    //3. Extract the name of 5thstore
    @Test
    public void findStoreName() {
        String storeName = response.extract().path("data[4].name");
        System.out.println("3) store name of 5th store : " + storeName);
    }

    //4. Extract the names of all the store
    @Test
    public void findAllStoreName() {
        List<String> allStoreName = response.extract().path("data.findAll{it}.name");

        System.out.println("4) All store names : " + allStoreName);
    }

    //5. Extract the storeId of all the store
    @Test
    public void findAllStoreId() {
        List<Integer> allStoreId = response.extract().path("data.findAll{it}.id");
        System.out.println("5) All store Id: " + allStoreId);
    }

    //6. Print the size of the data list
    @Test
    public void sizeOfData() {
        List<Integer> sizeOfData = response.extract().path("data");
        System.out.println("6) size of data: " + sizeOfData.size());
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void getAllValueofStCloud() {
        List<HashMap<String, ?>> allData = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("7) all values of st cloud: " + allData);
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void getAddress() {
        List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("8) Address of Rochester : " + address);
    }

    //9. Get all the services of 8th store
    @Test
    public void getAllVServices() {
        List<HashMap<String, ?>> allservices = response.extract().path("data.findAll{it.name=='Fargo'}.services");
        System.out.println("9) all services of 8th store fargo: " + allservices);
    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void getStoreServices() {
        //Map<String,?> storeServices= response.extract().path("data[7].services[5].storeservices");
      ArrayList<String> storeServices = response.extract().path("data.findAll{it.name =='Windows Store'}.services");
        System.out.println("10) Storeservices of service name window store : " + storeServices);
    }

    //11. Get all the storeId of all the store
    @Test
    public void getAllStoreId() {
        List<Integer> allStoreId = response.extract().path("data.find{it}.storeservices.storeId");
        System.out.println("11) All store Id od store: " + allStoreId);
    }

    //12. Get id of all the store
    @Test
    public void getAllId() {
        List<Integer> allId = response.extract().path("data.findAll{it}.id");
        System.out.println("12) All  Id of main store: " + allId);
    }

    //13. Find the store names Where state = ND
    @Test
    public void StoreName() {
        String storeName = response.extract().path("data.find{it.state == 'ND'}.name");
        System.out.println("13) store name of state ND : " + storeName);
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void totalServices() {
        List<Integer> services = response.extract().path("data.find{it.name=='Rochester'}.services");
        System.out.println("14) total number of services of store name Rochester : " + services.size());
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void createdAt() {
        String createdat = response.extract().path("data.find{it.service.name=='Windows Store'}.createdAt");

        System.out.println("15) createdAt of all service name window store : " + createdat);
    }

    //16. Find the name of all services Where store name = “Fargo”
    //17. Find the zip of all the store
    @Test
    public void findAllZip() {

        List<Integer> zip = response.extract().path("data.findAll{it}.zip");
        System.out.println("17) zip of all stores : " + zip);
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void findZipFromStoreName() {
        String zipOfStore = response.extract().path("data.find{it.name=='Roseville'}.zip");
        System.out.println("18) zip of rosville : " + zipOfStore);
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void findStoreServicesOfStore() {
        List<HashMap<String,?>> storeServiceDetail = response.extract().path("data.findAll{it.services=='Magnolia Home Theater'}.storeservices");
        System.out.println("19) store services of service name Magnolia Home Theater : " + storeServiceDetail);
    }
//20. Find the lat of all the store
    @Test
public void findLat(){
  List<Float> lat = response.extract().path("data.findAll{it}.lat") ;
        System.out.println("20) lat of all store : " + lat);
}
}