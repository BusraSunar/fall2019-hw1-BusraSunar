package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }

    public void testDivideByZero() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 0, 4));
        Boolean result = new App().divisible(array, 0);
        assertEquals(java.util.Optional.of(false), result);
    }
    public void testWrongInput() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        String result = new App().average(10, array);
        assertEquals("Input n is larger than array", result);
    }
    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        String result = new App().average(1, array);
        assertEquals("Input not found.", result);
    }
    public void testNull() {
        String result = new App().average(2, null);
        assertEquals("Input not found.", result);
    }
}