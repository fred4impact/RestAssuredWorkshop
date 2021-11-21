package GorestAPISamples;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class getUsers {

    @Test
    public void testToGetAllUsers(){

        String uRl = "https://gorest.co.in/public/v1/users";

        given()

            .when()
                .get(uRl)
            .then()
                .assertThat()
                .statusCode(200)
                .log().all();


    }
}
