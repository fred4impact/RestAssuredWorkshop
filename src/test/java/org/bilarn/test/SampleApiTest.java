package org.bilarn.test;

import io.restassured.RestAssured;
import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SampleApiTest {

    @BeforeClass
    void setBase(){
        baseURI="https://api.openbrewerydb.org";
        basePath="/breweries/5494";
    }


    @Test
    public void testGetMethod(){
        given()
                .log().all()
        .when()
           .get()
        .then()
            .assertThat();

    }


}
