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
public abstract class Passenger {
    
    private String name;
    private int age;
    
    public Passenger(String name, int age){
        
        this.name = name;
        this.age = age;
    }

    public Passenger(Passenger passenger){
        
        this.name = passenger.getName();
        this.age = passenger.getAge();
        
    }
    
    //return ticket value after discount in sub-classes
    public abstract double applyDiscount(double p);
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

    
}
