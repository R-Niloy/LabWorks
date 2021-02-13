/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author niloy
 */

public class ProceduralAbstraction {
    
    public static int reverseFactorial(int x) { 
  
           
            if (x <= 0) {
                
                return 1;
                
            }
            
            else{
            
                int n = 1, fact = 1;
                
                for( n=1; fact<x;  ){
                    
                    n++;
                    fact=fact*n;

                }

                return n;
                
            }
               
    }
    
    public static boolean isMatrixNice(int[][] arr) {
        
        int rowNumber = arr.length;
        int colNumber = arr[0].length;
        int[] sumRow = new int[rowNumber];
        int[] sumColumn= new int[colNumber];
        
       // System.out.println("Row length: " + rowNumber);
        
        if (colNumber == rowNumber){
           
            for(int i = 0; i < rowNumber; i++){
                
                int sumR=0;
                for (int j=0;j<colNumber;j++){
                    
                    sumR=sumR+arr[i][j];
                    
                }
                
                sumRow[i]=sumR;
                System.out.println("Sum of all the numbers of " + (i+1) +" row: " + sumRow[i]);  

            }
            for(int i = 0; i < colNumber; i++){  
                
                int sumC = 0;  
                for(int j = 0; j < rowNumber; j++){
                    
                    sumC= sumC + arr[j][i];
                    
                }
                
                sumColumn[i]=sumC;
                System.out.println("Sum of all the numbers of " + (i+1) +" Column: " + sumColumn[i]);  
              
            }
            
            int diagSum1 = 0, diagSum2 = 0;
            
            for (int i = 0; i < arr.length; i++) {
                
                    diagSum1 = diagSum1 + arr[i][i];
                    diagSum2 = diagSum2 + arr[arr.length - 1 - i][i];        
                 
            }
            
            System.out.println("Sum of all the numbers of Primary Diagonal: " + diagSum1);  
            System.out.println("Sum of all the numbers of Secondary Diagonal: " + diagSum2);  
            
            boolean result = Arrays.equals(sumRow, sumColumn);
            
            if(result) {
                if ((sumColumn[0]==diagSum1) && (sumColumn[0]==diagSum2)){
                    
                    return true;
                }
                
                else
                    return false;
            }

        else
            return false;
       
        }
        
        else 
            
            return false;
        
    }
    
    
    public static void main(String[] args) {
    
       
      
        Scanner scan = new Scanner(System.in);
        Scanner scan1= new Scanner(System.in);
    
        
        boolean flag = false;
        String input;
        int parameter;

        

        while (flag != true) {
            
            System.out.println("-----------------------------");
            System.out.println("");
            System.out.println("Lab2");
            System.out.println("Enter 1 to use reverseFactorial procedure with pre-defined value given on Lab manual.");
            System.out.println("Enter 2 to use user-defined(Input taken from user) reverseFactorial procedure.");
            System.out.println("Enter 3 to use magicSquare/isMatrixNice procedure with pre-defined values.");
            System.out.println("Enter 4 to use user-defined(Input taken from user) magicSquare/isMatrixNice procedure.");
            System.out.println("Enter e to exit");
       
            input = scan.nextLine();

            switch (input) {
                case "1":
                    
                    System.out.println("The value of smallest positive integer n for which n! is greater than or equal to given number(24): " + reverseFactorial(24));
                    System.out.println("The value of smallest positive integer n for which n! is greater than or equal to given number(119): " + reverseFactorial(119));
                    break;
                    
                case "2":
                    try{
                    System.out.println("Enter interger parameter: ");
                    parameter = scan.nextInt();
                    scan.nextLine();
                    System.out.println("The value of smallest positive integer n for which n! is greater than or equal to user-defined number("+parameter+"): " + reverseFactorial(parameter));
                    }
                 
                    catch(Exception e){
                        
                        System.out.println("Input not valid!");
                    }
                      
                    break;
     
                case "3":
                    
                    System.out.println("\n1st Matrix: ");
                    int mat1[][] = { 
                                        { 2, 7, 6 }, 
                                        { 9, 5, 1 }, 
                                        { 4, 3, 8 } 
                                    };
                    
                        if (isMatrixNice(mat1)) {
                            
                            System.out.println("Given Matrix fulfills all the Requirements.");
                            System.out.println("Nice Matrix!!");
                            
                         } 
                        
                        else {
                        
                            System.out.println("Requirements Not Met.");
                            System.out.println("Not a Nice Matrix!!");
                        }
                        
                        int mat2[][] = { 
                                            { -3, 1, 0 }, 
                                            { 4, -3, 4 }, 
                                            { 7, -9, 0 }  
                                          };
                        System.out.println("\n2nd Matrix: ");
                       if (isMatrixNice(mat2)) {
                            
                            System.out.println("Given Matrix fulfills all the Requirements.");
                            System.out.println("Nice Matrix!!");
                            
                         } 
                        
                        else {
                        
                            System.out.println("Requirements Not Met.");
                            System.out.println("Not a Nice Matrix!!");
                        }
                        break;
                
                case "4":
                    
                    try{
                    int rowUser,columnUser;
                    System.out.println("\nEnter the number of matrix's Row and Column :  ");
                    rowUser = scan1.nextInt();
                    columnUser = scan1.nextInt();
                    
                    int[][] userArray = new int[rowUser][columnUser];
                    
                    System.out.println("\nPlease Enter the elements of Array starting from first row (Use space to separate each row element!):  ");
                    System.out.println("NOTE: Only Input Positive/Negative Integers!");
                    
                    for(int i = 0; i < rowUser; i++) {
                        
			for(int j = 0; j < columnUser; j++) {
		
                            userArray[i][j] = scan1.nextInt();
			}		
                    }
                    
                    if (isMatrixNice(userArray)) {
                         
                        System.out.println("Given Matrix fulfills all the Requirements.");
                        System.out.println("Nice matrix");
                        
                    }
                    
                    else {
                        
                        System.out.println("Requirements Not Met.");
                        System.out.println("Not a Nice Matrix!!");
                        
                    }
                }
                    catch(Exception e){
                        System.out.println("Input not valid!");
                    }
                    
                    break;
            
                case "e":
                    flag = true;
                    System.out.println("End Program.");
                    break;
                    
                default:
                    System.out.println("Entered selection in not valid.Try Again!");
                    break;
                            
            }
                
        
        
    }
    
    }
       
    
}
