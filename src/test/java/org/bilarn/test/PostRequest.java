package org.bilarn.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostRequest {

   public static HashMap map = new HashMap();

    @BeforeClass
    void setUp(){
     // utilizing hash map for generated datas to use in post request
     map.put("username", common.getUsername());
     map.put("password", common.getPassword());
     map.put("password", common.getEmail());


      baseURI="https://api.openbrewerydb.org/breweries";
      basePath="?by_type=micro";

    }


    @Test
    void SendPostRequestTest(){
        given()

            .contentType("application/json")
            .body(map) // use the generated info as requiredby the API
        .when()
           .post()

        .then()
                .statusCode(201)
                .body("SuccessCode", equalTo("SUCCESS"));

    }
}
