package com.qcart;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Module4_Headers {



    @Test
    public void Query_Get_withHeaders(){
         given()
                    .baseUri("http://localhost:3000")
                    .header("Language","AR")
                    .headers("Language","AR","author","tredt")
                    .log().all()
         .when()
                    .get("courses")
         .then()
                    .log().all()
                 .assertThat().statusCode(200);
    }


    @Test
    public void Query_HeaderClass(){

       Header typeHeader = new io.restassured.http.Header("type","value");

        given()
                .baseUri("http://localhost:3000")
                .header(typeHeader)
                .log().all()
        .when()
                .get("courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void Query_HeadersClass(){

        Header typeHeader1 = new Header("type1","value2");
        Header typeHeader2 = new Header("type2","value2");
        Headers info = new Headers(typeHeader1,typeHeader2);

        given()
                .baseUri("http://localhost:3000")
                .headers(info)
                .log().all()
        .when()
                .get("courses")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }



    @Test
    public void Query_HeadersClassWitHashMap(){

        HashMap<String,String> inofHeader= new HashMap<>();
        inofHeader.put("key","value");
        inofHeader.put("key2","value2");


        given()
                .baseUri("http://localhost:3000")
                .headers(inofHeader)
                .log().all()
                .when()
                .get("courses")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }







}
