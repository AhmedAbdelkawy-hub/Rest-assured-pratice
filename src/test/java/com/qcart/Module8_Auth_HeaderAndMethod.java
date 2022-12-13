package com.qcart;

import com.POJOPage.LoginPojo2_constructor_Page;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Module8_Auth_HeaderAndMethod {

    LoginPojo2_constructor_Page authBody_Cons = new LoginPojo2_constructor_Page("admin","password123");

    // Auth By Constructor
    @Test
    public void Login_PoJo_constructor(){


        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(authBody_Cons).
                when()
                .post("/auth").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }
    @Test
    public void updateBookingWithAuth(){
        JSONObject Request = new JSONObject();
        Request.put("firstname","James");
        Request.put("lastname","Brown");
        Request.put("totalprice",111);
        Request.put("depositpaid",true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        Request.put("bookingdates",bookingdates);
        Request.put("additionalneeds","Breakfast");


        given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .auth().preemptive().basic("admin","password123")
                .body(Request).
                log().all()
        .when()
                .put("/booking/24").
        then()
                .assertThat().statusCode(200);

    }
}
