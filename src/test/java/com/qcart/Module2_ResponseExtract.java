package com.qcart;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Module2_ResponseExtract {


    @Test
    public void ExtractFullResponse(){
       Response Res =  given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then().extract().response();
        System.out.println(Res.asString());


    }

    @Test
    public void ExtractSpecificItemResponse(){
        Response Res =  given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then().extract().response();

        String Name = Res.path("[0].name");
        System.out.println(Name);


    }

    @Test
    public void ExtractItemUsingJsonPathClass(){
        Response Res =  given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then().extract().response();

        String Name = JsonPath.from(Res.asString()).getString("[0].name");
        System.out.println(Name);

    }

    @Test
    public void ExtractItemUsingThen(){
        String Name =  given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then().extract().response().path("[0].name");

        System.out.println(Name);

    }
}
