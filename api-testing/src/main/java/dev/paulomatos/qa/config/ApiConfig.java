package dev.paulomatos.qa.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {

    public static final String BASE_URL = "https://reqres.in/api";
    // reqres.in is a public hosted REST API — perfect for portfolio demos

    public static RequestSpecification buildSpec() {
        RestAssured.baseURI = BASE_URL;
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
