package com.qcart;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Module1_ResponseAssertion {


    @Test
    public void StatusCodeLogAll(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then().log().all()
                .assertThat().statusCode(200);

    }

    @Test
    public void EqualTo(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat()
                .body("[0].name",is(equalTo("Bob Parker")));
    }

    @Test
    public void HasItemItems(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("name",hasItem("Kelly Kiehn"))
                .assertThat().body("name",hasItems("Kelly Kiehn","Lynda Waelchi"));
    }

    @Test

    public void Contains(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("name",contains("Bob Parker", "Gerardo Ortiz", "Miss Al Fahey", "Kelly Kiehn", "Lynda Waelchi"))
                .assertThat().body("name",containsInAnyOrder("Bob Parker", "Gerardo Ortiz", "Miss Al Fahey", "Lynda Waelchi","Kelly Kiehn"));

    }
    @Test

    public void EmptyAndNotEmpty(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("name",not(empty()))
                .assertThat().body("name",empty());

    }
    @Test

    public void HasSize(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("name",hasSize(5));

    }

    @Test

    public void RetrieveSize(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("name.size()",equalTo(5));

    }


    @Test

    public void EveryItem(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
                .when().get("users")
                .then()
                .assertThat().body("createdAt",everyItem(startsWith("2022")));


    }

    @Test
    public void HasKeyValueEntry(){
        given().baseUri("https://6377d55e0992902a25123f9d.mockapi.io/Api/v1/")
        .when()
                .get("users")
         .then()
                .assertThat()
                .body("[0]",hasKey("id"))
                .body("[0]",hasValue("Bob Parker"))
                .body("[0]",hasEntry("id","1"));

    }
}
