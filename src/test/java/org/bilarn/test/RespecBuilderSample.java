package org.bilarn.test;

import static io.restassured.RestAssured.* ;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.omg.CORBA.Request;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RespecBuilderSample {

    @BeforeTest
    void setUp(){

        RequestSpecification res = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri("")
                .setBasePath("")
                .build();

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();

    }



 @Test
  void getTest(){
//    RequestSpecification r = given().spec(res);

  }
}
