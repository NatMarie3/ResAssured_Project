package test_util;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SpartansNoAuthBaseTest {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://35.171.112.34:8000";
        RestAssured.basePath = "/api";

    }

    @AfterAll
    public static void cleanup(){
        RestAssured.reset();
    }

}
