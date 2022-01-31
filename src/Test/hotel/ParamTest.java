package hotel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)

public class ParamTest
{
    String phoneNu;
    boolean expected;
    public ParamTest(String phoneNu,boolean expected)
    {
        this.phoneNu = phoneNu;
        this.expected= expected;
    }

    @Parameterized.Parameters(name= "{index}: isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"absdjkjasjk", false},
                        {"6532153113", true},
                        {"msdlksaldsa", false},
                        {"546545dasasa", false}, // if we change it as a true, test fails

                }
        );
    }

    ////////////////////////////////////MUTATION TEST METHODS///////////////////////////////////////////////
    @Test
    public void testIsValid() throws Exception
    {
        boolean actual= Customer.isValid(phoneNu);
        assertThat(actual, is(equalTo(expected)));
    }
    @Test
    public void testIsValid2() throws Exception // mutation test method for isValid method
    {
        boolean actual= Customer.isValid1(phoneNu);
        assertThat(actual, is(equalTo(expected)));
    }
    @Test
    public void testIsValid3() throws Exception // mutation test method for isValid method
    {
        boolean actual= Customer.isValid2(phoneNu);
        assertThat(actual, is(equalTo(expected)));
    }

}
