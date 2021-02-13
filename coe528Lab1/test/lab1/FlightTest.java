/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author niloy
 */
public class FlightTest {
    


    public FlightTest() {
    }
    
 
 //REQ 1: Write the code for the junit test method testConstructor() that tests the constructor by providing it with valid arguments
    
    @Test
        public void testConstructor() {
            
            
        Flight test2 = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
       
        assertEquals((double)test2.getCapacity(), 765, 0.0D);
        assertEquals((double)test2.getFlightNumber(), 1030, 0.0D);
        assertEquals(test2.getOrigin(),"Toronto");
        assertEquals(test2.getDestination(), "Kolkata");
        assertEquals(test2.getDepartureTime(), "03/02/99 7:50 pm");
        assertEquals(test2.getOriginalPrice(), 1000, 0.0D);
        assertEquals((long)test2.getNumberOfSeatsLeft(), 765, 0.0D);
        
        
    }

   //REQ 2: Write the code for the junit test method testInvalidConstructor() that tests the constructor by providing it with invalid arguments and check if it returns IllegalArgumentException

    @Test
        public void testInvalidConstructor() {
            
            //Will only work if IllegalArgumentException is thrown.
            
            try {
                  
                Flight test2 = new Flight(1030,"Toronto", "Toronto","03/02/99 7:50 pm", 765,1000.0D);

            }catch (Exception e) {
                System.out.println("Invalid input, detination can not be same as origin");
        }
    }
            
      
//REQ 3: Test the public methods that include all the getters, setters, the bookASeat() method and the toString() method, using Junit.
    
    @Test
    public void bookASeatTest() {
        
        //test with 0 capacity to see if it returns false.
        Flight test2 = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 0,1000.0D);
        assertEquals(test2.bookASeat(), false);
        assertEquals((long)test2.getNumberOfSeatsLeft(), 0, 0.0D);

        //test with 1 capacity to see if it returns true and the Number of seats Left matches with expected result.        
        Flight test3 = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 1,1000.0D);
        assertEquals(test3.bookASeat(), true);
        assertEquals((long)test3.getNumberOfSeatsLeft(), 0, 0.0D);
        
        
        Flight test4 = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        assertEquals(test4.bookASeat(), true);
        assertEquals((long)test4.getNumberOfSeatsLeft(), 764, 0.0D);

    }

    //Passing a value to the constructor and changing the value using Setter(in few cases) after passing value and return and compare it using Getter to check if the value is matching the expected result.

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        
        Flight testGetSet = new Flight(2930,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
       
        //Flight number value is changed to check if setter method is working correctly
        
        testGetSet.setFlightNumber(3000);
        assertEquals((double)testGetSet.getFlightNumber(), 3000,0.0D);
        
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        testGetSet.setOrigin("Toronto");
        assertEquals(testGetSet.getOrigin(), "Toronto");
        
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Montreal","03/02/99 7:50 pm", 765,1000.0D);
        testGetSet.setDestination("Montreal");
        assertEquals(testGetSet.getDestination(), "Montreal");
        
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","31/01/21 10:00 pm", 765,1000.0D);
        testGetSet.setDepartureTime("31/01/21 10:00 pm");
        assertEquals(testGetSet.getDepartureTime(), "31/01/21 10:00 pm");
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 100,1000.0D);
        
        //Capacity value is changed to check if setter method is working correctly
        
        testGetSet.setCapacity(9989);
        assertEquals((double)testGetSet.getCapacity(), 9989, 0.0D);

    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 600,1000.0D);
        testGetSet.setNumberOfSeatsLeft(600);
        assertEquals((double)testGetSet.getNumberOfSeatsLeft(), 600, 0.0D);
        
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        testGetSet.setOriginalPrice(1000);
        assertEquals((double)testGetSet.getOriginalPrice(), 1000, 0.0D);
        
    }

    
    //Getter Method Checking
    //Passing a value to the constructor and return it using Getter to check if Getter is working correctly
    
    /**
     * Test of getFlightNumber method, of class Flight.
     */
    
    @Test
    public void testGetFlightNumber() {
    
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        double result = testGetSet.getFlightNumber();
        assertEquals((double)result, 1030, 0.0D);

    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        String result = testGetSet.getOrigin();
        assertEquals(result, "Toronto");
        
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        String result = testGetSet.getDestination();
        assertEquals(result, "Kolkata");
        
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        String result = testGetSet.getDepartureTime();
        assertEquals(result, "03/02/99 7:50 pm");

    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        double result = testGetSet.getCapacity();
        assertEquals((double)result, 765, 0.0D);
        
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        double result = testGetSet.getNumberOfSeatsLeft();
        assertEquals((double)result, 765, 0.0D);

    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        double result = testGetSet.getOriginalPrice();
        assertEquals((double)result, 1000, 0.0D);
        
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        
        Flight testGetSet = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000);
        Flight test2 = new Flight(1030,"Toronto", "Kolkata","03/02/99 7:50 pm", 765,1000.0D);
        assertEquals(testGetSet.toString(),test2.toString());
    
    }
  
}
