package day1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Day 1 of Junit5 Test")
public class Junit5_Intro {
   @DisplayName("Testing Numbers")
    @Test
    public void test(){
        System.out.println("Learning Junit5");

        assertEquals(1,1);
        //assertEquals(1,1,"Something is wrong!");
    }
@DisplayName("Testing that name starts with A")
    @Test
    public void testName(){
        String name = "Emre";

       // assertEquals('E',name.charAt(0) );
    }

}
