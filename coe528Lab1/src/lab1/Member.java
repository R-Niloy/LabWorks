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
public class Member extends Passenger {
    
    private int yearsOfMembership;
    
     public Member(int yearsOfMembership, String name, int age){
         
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
        
    }

    public Member(Member member){
        
        super(member.getName(), member.getAge());
        this.yearsOfMembership = member.yearsOfMembership;
        
    }
    
    @Override
    public double applyDiscount(double p){
        
        do{
        
        if(yearsOfMembership>=0 && yearsOfMembership <=1  )
            return p;
        
        else if( 1< yearsOfMembership && yearsOfMembership<=5 )
            return p * .90;
            
        else
            return p * 0.50;
        
        }while((yearsOfMembership)>=0);
          
    }
    
}
