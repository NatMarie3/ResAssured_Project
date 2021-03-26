package day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Intro to RestAssured")
public class RestAssured_Intro {

    @DisplayName("Testing hello endpoint")
    @Test
    public void testHelloEndpoint() {
        Response response = get("http://35.171.112.34:8000/api/hello");
        // extracting information from Response object
        System.out.println(response.statusCode());
        System.out.println("response.getHeader(\"Content-Type\") = " + response.getHeader("Content-Type"));
        System.out.println(response.getTime());

        System.out.println("response.asString() = " + response.asString());
        assertThat(response.statusCode(), is(200));
        assertThat(response.contentType(), is("text/plain;charset=UTF-8"));
        assertThat(response.contentType(), startsWith("text/plain"));
        assertThat(response.asString(), is("Hello from Sparta"));
        System.out.println(response.getTime());

        response.prettyPrint();
    }

    @DisplayName("Testing get spartans")
    @Test
    public void testingSinsgleSpartan() {
        Response response =
                get("http://35.171.112.34:8000/api/spartans/16")
                        .prettyPeek();

        assertThat(response.statusCode(), is(equalTo(200)));
        assertThat(response.contentType(), is("application/json"));
        assertThat(response.header("Connection"), equalTo("keep-alive"));
        System.out.println("response.path(\"id\") = " + response.path("id"));
        System.out.println("response.path(\"name\") = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));

        int myId = response.path("id");
        String myName = response.path("name");
        long myNumber = response.path("phone");
        System.out.println("myId = " + myId);
        System.out.println("myName = " + myName);
        System.out.println("myNumber = " + myNumber);
    }

}
