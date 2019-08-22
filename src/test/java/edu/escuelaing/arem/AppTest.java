package edu.escuelaing.arem;

import java.text.DecimalFormat;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
 /**
     * Rigourous Test :-)
     */
    public void testApp1()
    {
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            LinkedList<Double> rta=App.calculo("160,591,114,229,230,270,128,1657,624,1503");
            assertEquals(df.format(rta.get(0)),"550.60");
            assertEquals(df.format(rta.get(1)),"572.03");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
     public void testApp2()
    {
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            LinkedList<Double> rta=App.calculo("15.0,69.9,6.5,22.4,28.4,65.9,19.4,198.7,38.8,138.2");
            assertEquals(df.format(rta.get(0)),"60.32");  
            assertEquals(df.format(rta.get(1)),"62.26");
        }
        catch(Exception e){
            System.out.println(e.getMessage());    
        }
    }
}
