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
public class NonMember extends Passenger {
    
    public NonMember(String name, int age){
        super(name, age);
    }

   
    public NonMember(NonMember nonMember){
        
        super(nonMember); 
    }

    public double applyDiscount(double p){
        
        if(this.getAge() > 65)
            return p * .90;
        else
            return p;
        
    }
}

