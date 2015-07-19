package easy;
import java.util.Random;
import java.util.Scanner;
public class challenge_4{
    public static void main(String args[]){
        Scanner inp = new Scanner(System.in);
        System.out.println("Random Password Generator\n");
        System.out.println("Enter the length of password");
        int len = inp.nextInt();
        System.out.println("Enter the no of passwords to be generated");
        int num = inp.nextInt();
        
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        int start = 0;
        int end = 26+10;
        int random_num;
        System.out.println("\nOUTPUT\n");
        for(int j=0;j<num;j++){
            
            String password="";
            
            for(int i = 0;i<len;i++){
                //generates a random number than the number specified
                random_num=r.nextInt(end);
                password+=letters.charAt(random_num);
            }
            
            System.out.println("The Random "+j+"th password is "+password);
        
        }
        
    }
}