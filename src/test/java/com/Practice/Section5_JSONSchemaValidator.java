package com.Practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Section5_JSONSchemaValidator {
    @Test
    public void TestGet(){

        given()
                .baseUri("http://localhost:3000")

        .when()
                .get("/courses")
        .then()
                .assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);


    }
}
