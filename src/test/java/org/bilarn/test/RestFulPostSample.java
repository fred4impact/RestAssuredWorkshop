package org.bilarn.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;


public class RestFulPostSample {

    private static final Logger logger
            = LoggerFactory.getLogger(RestFulPostSample.class);

    @Test
    public void newPostTestScenario(){


    String uRl = "https://gorest.co.in/public/v1/posts";
    logger.info("Step - 1 : Target resource ( server ) :" + uRl);
    
    String newBody = "{\"user_id\":\"49\", \"title\":\"CHRISTMAS  Sales IS ON \", \"body\":\"Lorem lorem hipsum \"}";

    logger.info("Step 2: Sending a Post Request to create New Post");
    Response response = RestAssured.given()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .auth().oauth2("5cb64076fa0104d180ba127aee0ce593960d4175f26b23dd4b78207abdfe690e")
            .body(newBody)
            .when()
            .post(uRl)
            .andReturn();

    logger.info("Step to get body response created");
    response.getBody().prettyPrint();

    logger.info("Step to verify status code response is code is 201 -");
    assertTrue(response.getStatusCode() == 201);

    logger.info(" the return status code is :" + response.statusCode());

    }

}
