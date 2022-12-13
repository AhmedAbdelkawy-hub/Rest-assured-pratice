package com.qcart;

import com.POJOPage.LoginPojo1_getter_setterPage;
import com.POJOPage.LoginPojo2_constructor_Page;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;




// Using APIes RestfullBooker

public class Module7_body_Pojo {

    LoginPojo1_getter_setterPage authBody_getter = new LoginPojo1_getter_setterPage();
    LoginPojo2_constructor_Page authBody_Cons = new LoginPojo2_constructor_Page("admin","password123");

    // Auth by Setter And Getter
    @Test
    public void Login_PoJo_Getter(){

        authBody_getter.setUsername("admin");
        authBody_getter.setPassword("password123");

        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON)
                .body(authBody_getter).
         when()
                .post("/auth").
         then()
                .log().all()
                .assertThat().statusCode(200);

    }

    // Auth By Constructor
    @Test
    public void Login_PoJo_constructor(){


        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                //.header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(authBody_Cons).
                when()
                .post("/auth").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }

}
