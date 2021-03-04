package myFizzBuzz;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    private static FizzBuzz fizzBuzz;
    @Before
    public void setUp(){
        fizzBuzz = new FizzBuzz();
    }
    private void checkFizzBuzz(int value, String expectedResult){
        String result = fizzBuzz.fizzBuzz(value);
        assertEquals(expectedResult, result);
    }
    @Test
    public void callFizzBuzz(){
//        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzz(1);
    }
    @Test
    public void return1With1PassedIn(){
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        assertEquals("1", fizzBuzz.fizzBuzz(1));
        checkFizzBuzz(1,"1");
    }
    @Test
    public void return2With2PassedIn(){
//        FizzBuzz fizzBuzz = new FizzBuzz();
//        assertEquals("2", fizzBuzz.fizzBuzz(2));
        checkFizzBuzz(2,"2");
    }
    @Test
    public void returnFizzWith3PassedIn(){
//        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
        checkFizzBuzz(3, "Fizz");
    }
    @Test
    public void returnFizzWith6PassedIn(){
        checkFizzBuzz(6, "Fizz");
    }
    @Test
    public void returnBuzzWith5PassedIn(){
        checkFizzBuzz(5, "Buzz");
    }
    @Test
    public void returnBuzzWith10PassedIn(){
        checkFizzBuzz(10, "Buzz");
    }
    @Test
    public void returnFizzBuzzWith15PassedIn(){
        checkFizzBuzz(15, "FizzBuzz");
    }

}