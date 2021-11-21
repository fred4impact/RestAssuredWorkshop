package org.bilarn.test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class BreweriesAPITestSample {

     private static final Logger logger = LoggerFactory.getLogger(BreweriesAPITestSample.class);

     @Test
     public void testTo_SearchBy_City_Sandiego(){
         String uRL = "https://api.openbrewerydb.org/breweries";

         logger.info(" Step 1:  Display base URL"  + uRL);

         Response response =

             given()
                 .queryParam("by_city", "san_diego")
              .when()
              .get(uRL)
              .andReturn();

         logger.info("Step 3: Assert the response status code = 200");
         Assert.assertEquals(response.getStatusCode(), 200);


         logger.info("Step 4: display response body");
         response.getBody().prettyPrint();


     }


     @Test
     public void testSearchBReWeries_ByLatitude(){

          String uRL = "https://api.openbrewerydb.org/breweries";

          given()
                  .queryParam("by_dist", "38.8977,77.0365")
                  .log().headers()
                  .when()
                  .get(uRL)
                  .then()
                  .assertThat()
                  .statusCode(200)
                  .log().all();


     }

     /*

         Using TestNG Dataprovider to create search city names

      */

     @Test(dataProvider = "stateData")
     public void testToSearchByState( String name){

         String uRL = "https://api.openbrewerydb.org/breweries";
         logger.info("Step - 1 :  Display the service endpoints" );

         given()
                 .queryParam("by_state", name)
         .when()
                 .get(uRL)
         .then()
              .assertThat().statusCode(200)
         .log().body();


     }



    @Test(dataProvider = "stateData")
    public void testWITHResponse( String name){

        String uRL = "https://api.openbrewerydb.org/breweries";
        logger.info("Step - 1 :  Display the service endpoints" + uRL + " " + name );

        Response  bodyRes =
                given()
                .queryParam("by_state", name)
                .when()
                .get(uRL)
                .andReturn();

        Assert.assertTrue(bodyRes.getStatusCode() == 200);
        logger.info(bodyRes.getBody().prettyPrint());


    }


    /*
       Dataprovider class for states

     */

     @DataProvider(name="stateData")
     public Object[][] createStateData() {
      return new Object[][]
              {
                  {"ohio"},
                  {"new_york"},
                  {"new%20mexico"}
              };

     }



}
