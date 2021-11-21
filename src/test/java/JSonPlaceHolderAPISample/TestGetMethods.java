package JSonPlaceHolderAPISample;

import Base.BaseConfig;
import  static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class TestGetMethods extends BaseConfig {

     /*
       Here we extends the base config class for al test to share
     */

    @Test
    void getTestScenario(){

        given()

                .when()
                    .get()
                .then()
                .assertThat()
                .statusCode(200)
                .log().body();
         logger.info("Step  to verify the status code return 200 ");

    }


    @Test
    void usingSpecForGet(){

        given()
              .spec(reqSpec)
        .when()
                .get()
        .then()
                .assertThat()
                .statusCode(200)
                .log().body();
        logger.info("Step  to verify the status code return 200 ");

    }


}
