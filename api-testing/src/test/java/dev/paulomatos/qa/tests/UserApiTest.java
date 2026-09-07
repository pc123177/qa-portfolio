package dev.paulomatos.qa.tests;

import dev.paulomatos.qa.config.ApiConfig;
import dev.paulomatos.qa.model.User;
import dev.paulomatos.qa.model.PageResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Users API")
public class UserApiTest {

    private RequestSpecification spec;

    @BeforeClass
    public void setup() {
        spec = ApiConfig.buildSpec();
    }

    @Test
    @Story("List users")
    @Description("GET /users returns paginated list with correct structure")
    public void listUsersShouldReturnPaginatedResult() {
        given(spec)
            .queryParam("page", 2)
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .body("data", not(empty()))
            .body("data[0].id", notNullValue())
            .body("data[0].email", containsString("@"));
    }

    @Test
    @Story("Single user")
    @Description("GET /users/{id} returns correct user data")
    public void getSingleUserShouldReturnCorrectData() {
        User user =
            given(spec)
            .when()
                .get("/users/2")
            .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .extract()
                .jsonPath()
                .getObject("data", User.class);

        assert user.getEmail() != null && !user.getEmail().isEmpty();
        assert user.getFirst_name() != null;
    }

    @Test
    @Story("Single user")
    @Description("GET /users/{id} with unknown id returns 404")
    public void getSingleUserNotFoundReturns404() {
        given(spec)
        .when()
            .get("/users/9999")
        .then()
            .statusCode(404);
    }

    @Test
    @Story("Create user")
    @Description("POST /users creates resource and returns 201 with id")
    public void createUserShouldReturn201WithId() {
        String body = """
                {
                  "name": "Paulo Matos",
                  "job": "SDET"
                }
                """;

        given(spec)
            .body(body)
        .when()
            .post("/users")
        .then()
            .statusCode(201)
            .body("id", notNullValue())
            .body("name", equalTo("Paulo Matos"))
            .body("job", equalTo("SDET"))
            .body("createdAt", notNullValue());
    }

    @Test
    @Story("Update user")
    @Description("PUT /users/{id} updates and returns 200 with updatedAt")
    public void updateUserShouldReturn200() {
        String body = """
                {
                  "name": "Paulo Matos",
                  "job": "Senior SDET"
                }
                """;

        given(spec)
            .body(body)
        .when()
            .put("/users/2")
        .then()
            .statusCode(200)
            .body("job", equalTo("Senior SDET"))
            .body("updatedAt", notNullValue());
    }

    @Test
    @Story("Delete user")
    @Description("DELETE /users/{id} returns 204 No Content")
    public void deleteUserShouldReturn204() {
        given(spec)
        .when()
            .delete("/users/2")
        .then()
            .statusCode(204);
    }
}
