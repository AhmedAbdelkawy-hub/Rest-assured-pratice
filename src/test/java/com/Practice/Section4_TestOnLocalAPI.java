package com.Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Section4_TestOnLocalAPI {
    @Test
    public void Get(){
        given()
                .baseUri("http://localhost:3000")
                .when()
                .get("/courses")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void Post(){
        JSONObject request = new JSONObject();
        request.put("title","ISTQB");
        request.put("author","maged");
        request.put("id",4);

        given()
                .baseUri("http://localhost:3000")
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .post("/courses")
        .then()
                .statusCode(201)
                .log().all();

    }
    @Test
    public void Put(){
        JSONObject request = new JSONObject();
        request.put("title","secrity");
        request.put("author","tytytyt");
        request.put("id",90);

        given()
                .baseUri("http://localhost:3000")
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/courses/4")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void Patch(){

        JSONObject Request = new JSONObject();
        Request.put("title","ISTQB");

        given()
                .baseUri("http://localhost:3000")
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Request.toJSONString())
                .when()
                .patch("/courses/4")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void DeleteTest(){
        given()
                .baseUri("http://localhost:3000").
        when()
                .delete("/courses/4")
                .then()
                .statusCode(200)
                .log().all();
    }
}
