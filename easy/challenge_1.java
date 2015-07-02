/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;
import java.util.Scanner;

/**
 *
 * @author Ashish Padalkar
 */
public class challenge_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your details:");
        System.out.println("Enter your name:");
        String name = s.nextLine();
        System.out.println("Enter your age:");
        int age = s.nextInt();
        
        System.out.println("Enter your Reddit Username:");
        String username = s.next();
                        //s.nextLine(); using nextline reads the line after the 
                        //the integer whish is a empty string so we should use next instead
        
        System.out.printf("your name is %s, you are %d years old, and your username is %s\n",name,age,username);
        
        // TODO code application logic here
    }
    
}
