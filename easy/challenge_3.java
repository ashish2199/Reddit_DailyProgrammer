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
public class challenge_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Program to Cipher text \n\n");
        System.out.println("Enter the key between -26 to 26");
        int key=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the String you want to encrpt");
        String inp = sc.nextLine();
        char c[]=inp.toCharArray();
        
        System.out.println("The encrpyted message is");
        for(int i=0;i<c.length;i++){
            
            int value = c[i];
            //for lower case letters
            if((value>=65&&value<=90)){
                
                if(key<0){
                    value=value+key+26;
                    
                    if(value>90){
                    value=value-26;
                    }
                    //System.out.println("v="+value);
                }else{
                    value += key;
                }
            }
            //for upper case letters
            if((value>=97&&value<=122)){
                if(key<0){
                    value=value+key+26;
                    
                    if(value>122){
                    value=value-26;
                    }
                    //System.out.println("v="+value);
                }else{
                    value += key;
                }
            }
            
            char output = (char)value;
            c[i]=output;
            System.out.print(""+c[i]);
        }
        
        System.out.println("");
        // TODO code application logic here
    }
    
}
