package org.bilarn.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion.*;

public class TestRestfulAPI {

//    private static Logger log = LoggerFactory.getLogger(TestRestfulAPI.class);
   private static Logger log = LoggerFactory.getLogger(TestRestfulAPI.class);



    @Test
    public void getAllUsers(){

         String uRl = "https://gorest.co.in/public/v1/users";


         log.info("Step 1: Send Get Request ");
         Response response = RestAssured.given().get(uRl).andReturn();

         log.info("Step 2: Get Response body");
         response.body().prettyPrint();

         log.info(" Step 3: Assert StatusCode = 200 ");
         Assert.assertEquals(response.getStatusCode(), 200);

         log.info(" Step 4 : verify that response contains");
         log.info("list of Student's Id " +response.getBody().jsonPath().getList("id"));
         Assert.assertTrue(response.getBody()
                 .jsonPath()
                 .getList("data.id")
                 .contains(2579)
         );

    }

}
