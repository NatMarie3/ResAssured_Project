package day2;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_util.SpartansNoAuthBaseTest;

@DisplayName("Spartan test with path var and query param")
public class day2_SpartanTest_PathQueryParam extends SpartansNoAuthBaseTest {
    @Test
    public void getOneSpartan() {

        Response r1 =
                get("/spartans/16").prettyPeek();

        given()
                .header("Accept", "application/json")
                .pathParam("spartan_id", 16).
                when()
                .get("/spartans/{spartan_id}")
                .prettyPeek()
        ;

        Response r2 =
                given()
                        .accept("application/json").
                        when()
                        .get("/spartans/{spartan_id}", 16)
                        .prettyPeek();

    }

    @DisplayName("logging the request")
    @Test
    public void getOneSpartanWithLog() {

        Response response =
                given()
                        .log().all()
                        .accept("application/json")
                        .pathParam("id", 1611).
                        when()
                        .get("/spartans/{id}")
                        .prettyPeek();

        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.contentType() , is("application/json"));
    }

}
