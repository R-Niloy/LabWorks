/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author niloy
 */
public class Flight {
    
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
     public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice){
        try {
            if (origin.equals(destination))
                throw new IllegalArgumentException("Invalid input, Destination can not be same as Origin");
            else {
                this.flightNumber = flightNumber;
                this.origin = origin;
                this.destination = destination;
                this.departureTime = departureTime;
                this.capacity = capacity;
                
                this.numberOfSeatsLeft = capacity;
                this.originalPrice = originalPrice;
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
     }
     

     
    public boolean bookASeat(){
        if(numberOfSeatsLeft > 0){
            numberOfSeatsLeft=numberOfSeatsLeft -1;
            return true;
        }
        else{
            return false;
        }
    }


    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    @Override
    public String toString() {
        return ("Flight " + flightNumber + ", " + origin + " to " + destination + " " + departureTime + ", original price: " + originalPrice + "$");
    }
    
  
}
