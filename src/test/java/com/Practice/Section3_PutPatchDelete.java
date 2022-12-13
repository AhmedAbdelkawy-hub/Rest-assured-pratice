package com.Practice;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Section3_PutPatchDelete {

    @Test
    public void PutTest(){

        JSONObject Request = new JSONObject();
        Request.put("name","Abdelkawy");
        Request.put("job","senior");
        System.out.println(Request.toJSONString());


        given()
                .baseUri("https://reqres.in")
                .header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Request.toJSONString())
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void PatchTest(){

        JSONObject Request = new JSONObject();
        Request.put("name","Abdelkawy");
        Request.put("job","senior");
        System.out.println(Request.toJSONString());

        baseURI = "https://reqres.in";
        given().
                header("Content-Type","Application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Request.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void DeleteTest(){
        baseURI = "https://reqres.in";
                when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }
}
