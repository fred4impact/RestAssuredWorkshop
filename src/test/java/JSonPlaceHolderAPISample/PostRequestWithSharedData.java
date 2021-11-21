package JSonPlaceHolderAPISample;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.bilarn.test.RestFulPostSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithSharedData {

    private static final Logger logger
            = LoggerFactory.getLogger(RestFulPostSample.class);


    @Test
    public void createPostAndExtractId(){

        String url = "https://jsonplaceholder.typicode.com/posts";
        String reqBody = "{\"title\":\"THE NEW BOOK STORY\", \"body\":\"Lorem Lorem lorem\", \"userId\":1}";

        logger.info("Step - 1 : Send in the header and Post  request  with : "  +  url );

         /*
            Sample on how to share variable data in Tests
            This Test Create a new resource and capture the id of the new resource using POST
            send it in as the parameter entry to GET Method
         */


    int userId =

        given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(reqBody)
        .when()
                .post(url)
        .then()
                .extract()
                    .path("userId");

        logger.info("Step - 2 : get the newly created userid"  + " " + userId);

        /*
             This is sample of a nested test
        */
        given()
            .pathParam("userId", userId)
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/{userId}")
        .then()
            .assertThat()
            .statusCode(200)
            .log().all();

        logger.info("Step - 3 : Response validated 200");





    }

}
