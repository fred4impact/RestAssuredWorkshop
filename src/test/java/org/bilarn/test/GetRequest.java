package org.bilarn.test;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest {


    @BeforeClass
    void setUp(){
//         baseURI="https://api.openbrewerydb.org/breweries/search";
//         basePath="?query=dog";
     }


//     @Test(enabled = false)
//    void GetMethodTest(){
//             given()
//
//            .when()
//                   .get("https://api.openbrewerydb.org/breweries")
//            .then()
//                 .statusCode(200).statusLine("HTTP/1.1 200 OK")
//                     .log().all()
//                 .assertThat()
//                 .body("name", hasItem("Bnaf, LLC")) .and().assertThat()
//             .body("brewery_type", hasItem("planning"));
//
//
//     }

     @Test
    void GetMethodTestByMacro(){
        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all();

    }

     @Test
    void getAdress_as_kulass(){
        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .body("website", hasItem("demarco.info"))
                .and().statusCode(200)
                .log().all();

    }

    @Test
    void getIDandEmail(){
        given()
                .when()
                .get("http://jsonplaceholder.typicode.com/users")
                .then()
                .assertThat()
                .body("id", hasItem(1))
                .and().body("company[0].name", equalTo("Romaguera-Crona"))
                .statusCode(200)
                .log().all();

    }

    @Test
    void getInGorestAPI(){
        given()
//                .auth().oauth2("5cb64076fa0104d180ba127aee0ce593960d4175f26b23dd4b78207abdfe690e")
                .when()
                .get("https://gorest.co.in/public/v1/todos")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();


    }


    /*
       Sample hashmap to generate data as data provider

     */

    @Test(dataProvider = "student")
    void sampleDataGetTest(){
      given()
              .when().get()
              .then()
              .assertThat()
              .statusCode(201)
              .log().body();
    }


    @DataProvider(name="student")
    public Object[] dataMap(){
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Jackson");
        data.put("city", "New York");
        data.put("address", "Social street");
        data.put("email", "jackson1@gmail.com");
        return new Object[0];
    }



     /*
      end of hashmap to generate data

     */


}
