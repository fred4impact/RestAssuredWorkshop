package TestBreweries;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.bilarn.test.BreweriesAPITestSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static  org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.List;

public class testGetMethods {

    private static final Logger logger = LoggerFactory.getLogger(testGetMethods.class);

    @Test
    public void testSearchState(){

        String URL = "https://api.openbrewerydb.org/breweries";

        logger.info("Step - 1 : Send GET Request");
        Response response = given()
                .queryParam("by_state", "ohio")
                .get(URL).andReturn();

        logger.info("Step - 2 : Print the JSON response body");
        response.getBody().prettyPrint();

        logger.info("Step - 3 : Assert StatusCode = 200");
        assertTrue(response.getStatusCode()==200);

        logger.info("Step - 4 :Create a JSONPath object");
        JsonPath jpath = response.jsonPath();

        logger.info("Step - 5 :Use JsonPath to get the list of all Breweries Product Name");
        // In java code you DO NOT have to write expression starting with `$`
        List<String> dname = jpath.get("name");
        logger.info("List of all Breweries Product Names : " + dname.toString() + "   ");

        logger.info("Step - 6 :Use JsonPath to get the states of the Breweries record");
        String name = jpath.get("name[0]");
        String type = jpath.get("brewery_type[0]");
        logger.info("Print the first name of the Breweries record: " + name.toString());
        logger.info("Print the first type of the Breweries record: " + type.toString());




    }

}
