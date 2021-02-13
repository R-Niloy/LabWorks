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
public class Ticket {
    
    private static int ticketNumber = 1;
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;

    public Ticket(Passenger passenger, Flight flight, double price) {
        
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.number=ticketNumber++;
        
    }

 
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        
        return passenger.getName() + ", " + flight.toString() + ", Ticket Price: $" + price;

    }
    
    
}
