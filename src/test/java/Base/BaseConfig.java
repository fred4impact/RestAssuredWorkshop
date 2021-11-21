package Base;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import org.bilarn.test.RestFulPostSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class BaseConfig {

    // Logger instantiation
    public static final Logger logger  = LoggerFactory.getLogger(BaseConfig.class);
    public static RequestSpecification reqSpec ;


    @BeforeClass
    public static void setUp(){

//        baseURI = "https://jsonplaceholder.typicode.com";
//        basePath = "/posts";

        /*
        port = 8080; if using localhost api
        */

       reqSpec = new RequestSpecBuilder()
                        .setBaseUri("https://jsonplaceholder.typicode.com")
                        .setBasePath("/posts")
                        .setContentType(ContentType.JSON)
                        .build();

         /*
          instantiate the respect
          */



    }
}
