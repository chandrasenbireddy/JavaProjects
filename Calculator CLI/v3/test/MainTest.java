package v3.test;

import org.junit.jupiter.api.Test;
import v3.CaliculatorCli;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void testAdd(){
        assertEquals(2, CaliculatorCli.add(1,1));
    }
    @Test
    void testSubtract(){
        assertEquals(1.5, CaliculatorCli.substract(3,1.5));
    }
    @Test
    void testMultiply(){
        assertEquals(24,CaliculatorCli.multiply(3,8));
    }
    @Test
    void testDivideNormal(){
        assertEquals(2, CaliculatorCli.divide(4,2));
    }
    @Test
    void testDivideByZero(){
        assertTrue(Double.isNaN(CaliculatorCli.divide(4,0)));
    }
    @Test
    void testCaculateAddition(){
        assertEquals(7, CaliculatorCli.calculate(4,3,'+'));
    }
    @Test
    void testcaliculateInvalidOperator(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{CaliculatorCli.calculate(3,4,'$');});
        assertTrue(exception.getMessage().contains("send a proper operator"));
    }
}
