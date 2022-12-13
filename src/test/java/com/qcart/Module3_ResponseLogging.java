package com.qcart;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class Module3_ResponseLogging {



    @Test
    public void Logging_Request_Data_And_Response_Data(){
         given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().all()
                .when().get("users")
                .then().log().all();
    }

    @Test
    public void Logging_Request_Body(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().body()
                .when().get("users")
                .then();
    }

    @Test
    public void Logging_Request_Header(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().headers()
                .when().get("users")
                .then();
    }

    @Test
    public void Logging_Request_Parameter(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().parameters()
                .when().get("users")
                .then();
    }
    @Test
    public void Logging_Request_Method(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().method()
                .when().get("users")
                .then();
    }
    @Test
    public void Logging_Request_IfError(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().method()
                .when().get("users")
                .then().log().ifError();
    }

    @Test
    public void Logging_With_Validation_Error(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/").log().method()
                .when().get("users")
                .then().log().ifValidationFails()
                .body("[0].name",equalTo("Bob Parker"));
    }


}
