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
public class challenge_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Physics Force Calculator");
        System.out.println("What do you want to calculate : F-Force M-Mass A-Acceleration");
        String option = sc.next();
        if(option.equals("F")){
            System.out.println("Enter the value for Mass:");
            int m = sc.nextInt();
            System.out.println("Enter the value for Acceleration:");
            int a = sc.nextInt();
            int f=m*a;
            System.out.printf("The Value of force is %d N\n",f);
        }
        if(option.equals("M")){
            System.out.println("Enter the value for Force:");
            int f = sc.nextInt();
            System.out.println("Enter the value for Acceleration:");
            int a = sc.nextInt();
            double m=((double)f)/a;
            System.out.printf("The Value of mass is %f Kg\n",m);
        }
        if(option.equals("A")){
            System.out.println("Enter the value for Force:");
            int f = sc.nextInt();
            System.out.println("Enter the value for Mass:");
            int m = sc.nextInt();
            double a=((double)f)/m;
            System.out.printf("The Value of Acceleration is %f m/s^-2\n",a);
        }
        
        // TODO code application logic here
    }
    
}
