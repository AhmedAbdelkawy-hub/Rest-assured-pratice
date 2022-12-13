package com.qcart;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


// Using APIes RestfullBooker
public class Module6_bodyTests_File_HashMap_etc {


    @Test
    public void Auth_Post_Body_As_String(){
        String body = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(body).
        when()
                .post("/auth").
        then()
                .log().all()
                .assertThat().statusCode(200);

    }

    @Test
    public void Auth_Post_Body_As_AFile(){

        File authBody= new File("src/test/resources/login.json");

        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(authBody).
                when()
                .post("/auth").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }
    //Pre request Adding maven dependency jackson
    @Test
    public void Auth_Post_Body_As_HashMap(){
        HashMap<String,String> authBody = new HashMap<>();
        authBody.put("username","admin");
        authBody.put("password","password123");


        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(authBody).
                when()
                .post("/auth").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }

//Just In case
    @Test
    public void Auth_BodyAs_UrlEncoded(){
        HashMap<String,String> formParam = new HashMap<>();
        formParam.put("foo","123");



        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.URLENC)
                .formParams(formParam).
        when()
                .post("/auth").
         then()
                .log().all()
                .assertThat().statusCode(200);

    }

    // Just In case
    @Test
    public void Auth_BodyAs_formdata_multifile(){
        File formDataBodyJson = new File("src/test/resources/login.json");


        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.URLENC)
                .multiPart("file","formDataBodyJson").
        when()
                .post("/auth").
        then()
                .log().all()
                .assertThat().statusCode(200);

    }

}
