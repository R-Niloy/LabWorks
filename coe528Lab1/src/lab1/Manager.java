/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author niloy
 */
public class Manager {
    
    private  static List<Flight> flights = new ArrayList<Flight>();
    private  static List<Ticket> tickets = new ArrayList<Ticket>();
    //private static int flightNumber = 1;

    public static String createDepartureTime(int DD, int MM, int YYYY, String time){
        return DD + "/" + MM + "/" + YYYY + " " + time ;
    }
    
    
    public static void createFlights() {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!! Here you can add the Flight Information.");
        System.out.println("Press enter to continue.");
        String decision=scan.nextLine();
    try{
       do{
            
            System.out.println("Kindly enter the information below about the flight");
            System.out.println("Enter the Flight Number(Numeric Value Only): ");
            int flightNumber=scan.nextInt();
            scan.nextLine();
            
            System.out.println("Enter the Origin City: ");
            
            String origin=scan.nextLine();
            
            System.out.println("Enter the Destination City: ");
            String destination=scan.nextLine();
            
            System.out.println("Enter Departure date and time");
            System.out.println("Kindly use the following format: DD/MM/YYYY HH:MM am/pm");
            
            System.out.println("Departure Date: ");
            int DD = scan.nextInt();
            scan.nextLine();
    
            
            System.out.println("Departure Month: ");
            int MM = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Departure Year: ");
            int YYYY = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Departure Time: ");
            
            System.out.println("Add am/pm after Scheduled time."); 
            String time  = scan.nextLine();
            
            if(DD<0 || DD>31 || MM<1 || MM>12 || YYYY<1914 || YYYY>99999 ){
                System.out.println("Invalid Date! Check again! Note: 1st passenger plane operated in 1914, input year lesser than 1914 is not accepted.");
            }
            else{
            System.out.println("Capacity: ");
            int capacity = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Ticket Price: ");
            int price = scan.nextInt();
            scan.nextLine();

            Flight F = new Flight(flightNumber, origin, destination, createDepartureTime(DD, MM, YYYY, time), capacity, price);
            flights.add(F);
            System.out.println("The following flight has been added:");
            System.out.println(F);
            }
    
          
            System.out.println("Do you want to continue? Yes/No");
            decision =scan.nextLine();
            

        }while((decision.equals("Yes") || decision.equals("yes")));
       
               
        if(decision.equals("No") || decision.equals("no")){
            System.out.println("All Done!");
        }
        else
            System.out.println("Invalid Request.Kindly Try again!");
        }
    catch(Exception e){
        System.out.println("Invalid input detected!");
    }
    
        
    }
    
      public void displayAvailableFlights(String origin, String destination) {
        int size, seats;
        boolean flag = true;
        String o, d;
        size = flights.size();
        for (int i = 0; i < size; i++) {
            o = flights.get(i).getOrigin();
            d = flights.get(i).getDestination();
            seats = flights.get(i).getNumberOfSeatsLeft();
            if ((o.equals(origin) == true) && (d.equals(destination) == true) && seats > 0) {
                if (flag == true) {
                    System.out.println("List of available flights:");
                    flag = false;
                }
                System.out.println(flights.get(i));
            }
        }
        if (flag == true) {
            System.out.println("no available flights");
        }
      }
    
        public Flight getFlight(int flightNumber) {
        int size = flights.size();
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                return flights.get(i);
            }

        }
        return null;
    }

    public void bookSeat(int flightNumber, Passenger p) {
        int size = flights.size();
        boolean flag = false;
        int index = 0, seats;
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getFlightNumber() == flightNumber) {
                flag = true;
                index = i;
                break;
            }

        }
        double price;
        seats = flights.get(index).getNumberOfSeatsLeft();
        if (flag == true && (seats > 0)) {
            flights.get(index).bookASeat();
            price = p.applyDiscount(flights.get(index).getOriginalPrice());
            Ticket a = new Ticket(p,flights.get(index), price);
            tickets.add(a);
            System.out.println("You have succesfully booked a seat for the following flight " + flightNumber);
            System.out.println("ticket: " + a);



        } else {
            if (flag == true && seats == 0) {
                System.out.println("The Flight " + flightNumber + " is fully booked, you cannot book a ticket for this flight. Sorry for the inconvenience");

            } else if (flag == false) {
                System.out.println("The Flight with flight number: " + flightNumber + " does not exist");
            }
        }

    }

    public static void main(String[] args){
        {
        Manager flightManager = new Manager();
        Flight F;
        Passenger P;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        String input, destination, origin, name;
        int flightNumber, age, years;
        boolean flag = false;

        while (flag != true) {
            
            System.out.println("                                Menu Options                ");
            System.out.println("NOTE: Option 2, 3 and 4 can not be initiated without including Flight Data first.");
            System.out.println("");
            
            System.out.println("Requirement 1: Enter 1 to use creatFlight method");
            System.out.println("Requirement 2: Enter 2 to use displayAvailableFlights method");
            System.out.println("Requirement 3: Enter 3 to use getFlight method");
            System.out.println("Requirement 4: Enter 4 to use bookSeat method");
            System.out.println("               Enter e to exit     ");
            System.out.println("");

            input = scan1.nextLine();

            switch (input) {
                
                case "1":
                    flightManager.createFlights();
                    break;
                
                case "2":
                    System.out.println("Enter flight origin");
                    origin = scan1.nextLine();
                    System.out.println("Enter flight destination");
                    destination = scan1.nextLine();
                    flightManager.displayAvailableFlights(origin, destination);
                    break;
                
                case "3":
                    System.out.println("Enter Flight number");
                    flightNumber = scan2.nextInt();
                    F = flightManager.getFlight(flightNumber);
                    if (F == null) {
                        System.out.println("Flight " + flightNumber + " does not exist");
                    } else {
                        System.out.println("Information found for flight number: " + flightNumber + "-> ");
                        System.out.println(F);
                    }
                    break;
                    
                case "4":
                    System.out.println("If passenger is memeber press a, if passenger is a non-member press b");
                    input = scan1.nextLine();
                    
                    System.out.println("Enter Passenger's name");
                    name = scan1.nextLine();
                    
                    System.out.println("Enter Passenger's age");
                    age = scan2.nextInt();
                    
                    System.out.println("Enter flight number");
                    flightNumber = scan2.nextInt();

                    if (input.equals("b") == true) {
                        P = new NonMember(name,age);
                        flightManager.bookSeat(flightNumber, P);
                    } else if (input.equals("a") == true) {
                        
                        System.out.println("Kindly enter the duration of membership for the frequent flyer program: ");
                        years = scan2.nextInt();
                        P = new Member(years, name, age);
                        flightManager.bookSeat(flightNumber, P);

                    }
                    break;
                
                case "e":
                    flag = true;
                    System.out.println("Program is terminated");
                    break;
                
                default:
                    System.out.println("Entered selection in not valid.Try Again!");
                    break;

            }

        }
    }

}
    

}
