package GorestAPISamples;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.bilarn.test.RestFulPostSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class UsingExtractWithPost {


    private static final Logger logger
            = LoggerFactory.getLogger(RestFulPostSample.class);


    @Test
    public void extractPostDataAndReuse()
    {
        String url = "https://gorest.co.in/public/v1/users";
        String reqBody = "{\"name\":\"Bar Row\", \"gender\":\"male\", \"email\":\"berly@gmail.com\", \"status\":\"inactive\"}";

        logger.info("Step - 1 : Send in the header and Post  request");

         /*
            Sample on how to share variable data in Tests
         */

    String id =

        given()
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .auth().oauth2("3b03ac67d8ff4eda624c215babc78dcbf6dc8af304395c031c66e4a66d3a4d73")
            .body(reqBody)
        .when()
            .post(url)
        .then()
            .extract()
            .path("id");

         logger.info("Step - 2 : get the newly created userid"  + id);

        /*
             This is sample of a nested test
        */

        given()
            .pathParam("userId", id)
        .when()
            .get("https://gorest.co.in/public/v1/users/{id}")
        .then()
              .assertThat()
              .statusCode(200);

         logger.info("Step - 3 : Response validated 200");



    }
}
