package easy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class challenge_5{
    public static void main(String args[]) throws FileNotFoundException, IOException{
        System.out.println("**** Please Authenticate yourself ****");
        Scanner sc = new Scanner(System.in);
        File f = new File("usr_psd.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String current_line;
        String user_details[][]=new String[100][2];
        int i=0;
        while((current_line = br.readLine()) != null){
             String content[]=current_line.split(":");
             user_details[i][0]=content[0];
             user_details[i][1]=content[1];
             i++;
        }
        Boolean access=false;
        do{
        System.out.print("Enter your username :");
        String username=sc.nextLine();
        System.out.print("Enter your password:");
        String password=sc.nextLine();
        
            for(int k=0;k<i;k++){
                if(username.equals(user_details[k][0])){
                    if(password.equals(user_details[k][1])){
                        access=true;
                    }
                }
            }
            if(!access){
                System.out.println("\nWrong details provided\nPlease re-enter your details\n");
            }
        }
        //**a comma is needed after while in do while** 
        while(!access);
        
        
        //The program to be run when uer has logged in 
        {
            System.out.println("You have successfully logged in");
        }
    }
}