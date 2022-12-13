package com.qcart;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Module5_QueryParameters {



    @Test
    public void Query_Parameters(){
         given()
                    .baseUri("http://localhost:3000")
                    .queryParam("Language","EN")
                    .log().all()
         .when()
                    .get("courses")
         .then()
                    .log().all()
                 .assertThat().statusCode(200);
    }
    @Test
    public void Query_Parameters_byHashMap(){

        HashMap<String,String> Query = new HashMap<>();
        Query.put("Language","EN");

          given()
                .baseUri("http://localhost:3000")
                .queryParams(Query)
                .log().all()
                .when()
                .get("courses")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }









}
