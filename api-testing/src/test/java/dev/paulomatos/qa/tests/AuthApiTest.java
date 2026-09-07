package dev.paulomatos.qa.tests;

import dev.paulomatos.qa.config.ApiConfig;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Auth API")
public class AuthApiTest {

    private RequestSpecification spec;

    @BeforeClass
    public void setup() {
        spec = ApiConfig.buildSpec();
    }

    @Test
    @Story("Login")
    public void loginWithValidCredentialsShouldReturn200WithToken() {
        String body = """
                {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                }
                """;

        given(spec)
            .body(body)
        .when()
            .post("/login")
        .then()
            .statusCode(200)
            .body("token", notNullValue())
            .body("token", not(emptyString()));
    }

    @Test
    @Story("Login")
    public void loginWithMissingPasswordShouldReturn400() {
        String body = """
                {
                  "email": "eve.holt@reqres.in"
                }
                """;

        given(spec)
            .body(body)
        .when()
            .post("/login")
        .then()
            .statusCode(400)
            .body("error", equalTo("Missing password"));
    }

    @Test
    @Story("Register")
    public void registerWithMissingPasswordShouldReturn400() {
        String body = """
                {
                  "email": "sydney@fife"
                }
                """;

        given(spec)
            .body(body)
        .when()
            .post("/register")
        .then()
            .statusCode(400)
            .body("error", equalTo("Missing password"));
    }
}
