package org.bilarn.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostRequestSample {


    @Test
    public void createNewPostTest(){

        String uRl = "https://gorest.co.in/public/v1/posts";
        String newBody = "{\"user_id\":\"49\", \"title\":\"NEW POST FROM 49\", \"body\":\"juST POSTING NEW SERIRES\"}";

       given()
           .header("Accept", "application/json")
           .header("Content-Type", "application/json")
           .auth().oauth2("5cb64076fa0104d180ba127aee0ce593960d4175f26b23dd4b78207abdfe690e")
           .body(newBody)
       .when()
            .post(uRl)
       .then()
           .assertThat()
           .statusCode(201)
           .log().all();
    }


    @Test
    public void getNewCreatedPost(){
        String urlPath = "https://gorest.co.in/public-api/posts/1380";

        given()
           .when()
            .get(urlPath)
           .then()
                .assertThat().statusCode(200)
                .and()
                .body("data.title", equalTo("NEW POST FROM 49"))
                .log().body();



    }


}
