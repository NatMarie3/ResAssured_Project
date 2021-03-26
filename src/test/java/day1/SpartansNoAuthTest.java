package day1;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_util.SpartansNoAuthBaseTest;

public class SpartansNoAuthTest extends SpartansNoAuthBaseTest {
    @Test
    public void getAllSpartans(){

        get("/spartans").prettyPeek();
    }

    @Test
    public void sayHello(){
        get("/hello").prettyPeek();
    }
}
