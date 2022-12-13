package com.Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Section2_Get_And_Post {
    @Test
    public void GetTest(){
        given()
                .baseUri("https://reqres.in/api")
        .when()
                .get("/users?page=2").
        then()
                .body("data[0].first_name",equalTo("Michael"))
                .body("data.first_name",hasItems("Michael","Lindsay"));


    }
    @Test
    public void PostTest(){
        JSONObject Request = new JSONObject();
        Request.put("name","Ahmed Abdo");
        Request.put("job","senior");
        System.out.println(Request.toJSONString());


        given()
                 .baseUri("https://reqres.in/api")
                 .header("Content-Type","Application/json")
                 .contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .body(Request.toJSONString())
         .when()
                 .post("/users")
         .then()
                 .statusCode(201)
                 .log().all();
    }
}
