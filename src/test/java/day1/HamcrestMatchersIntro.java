package day1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @Test
    public void simpleTest1(){
        assertThat(5+5,is(10));
        assertThat(5+5,equalTo(10));
        assertThat(5+5,is(equalTo(10)));
        assertThat(5+5,not(11));
        assertThat(5+5, is(not(11)));
        assertThat(5+5,is(not( equalTo(11))));

        assertThat(5+5, is( greaterThan(9)) );
    }
@DisplayName("Matchers related to Strings")
    @Test
    public void stringMatchers(){
        String msg = "B21 is learning Hamcrest";
        assertThat(msg,is("B21 is learning Hamcrest"));
        assertThat(msg,equalTo("B21 is learning Hamcrest"));
        assertThat(msg,is(equalTo("B21 is learning Hamcrest")) );

        assertThat(msg,startsWith("B21"));
        assertThat(msg,startsWithIgnoringCase("b21"));
        assertThat(msg,endsWith("rest"));

        String str = " ";
        assertThat(str,blankString());
        assertThat(str.trim(),emptyString() );

}

    @DisplayName("Hamcrest Support for Collection")
    @Test
    public void testCollection(){
        List<Integer> lst = Arrays.asList(1,4,7,3,7,3,7,44,88,99,44);
        assertThat(lst, hasSize(11));
        assertThat(lst,hasItem(7));
        assertThat(lst,everyItem(greaterThan(0)));
    }

}
