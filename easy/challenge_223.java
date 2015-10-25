/*
[2015-07-13] Challenge #223 [Easy] Garland words
*/
package easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class challenge_223{
                            //varargs
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Challenge (main)");
        System.out.println("Please enter the word");
        
        String inp = sc.nextLine();
        
        int garland=find_garland_length(inp);
        
        System.out.println("\nThe highest degree of garland length in this word "
                + "is "+garland);
        
        System.out.println("\nChallenge (optional #1)");
        
        System.out.println("The garland chain is");
        int k=10;
        System.out.print(""+inp);
        while(k-->0){
            System.out.print(""+inp.substring(garland));
        }
        System.out.println("");
    
        
        System.out.println("\nChallenge (optional #2)");
        
        File f = new File("enable1.txt");
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String word;
            int max=0;
            while((word=br.readLine())!=null){
                int g= find_garland_length(word);
                if(g>max){max=g;}
            }
            System.out.println("The highest degree of garland is "+max);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(challenge_223.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(challenge_223.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static int find_garland_length(String inp) {
        int garland=0;
        for(int i=1;i<inp.length();i++){
            
            String start = inp.substring(0,inp.length()-i);
            String end = inp.substring(i, inp.length());
            //System.out.println("Start = "+start+" and end = "+end);
            
            if(start.equals(end)){
                garland=(inp.length()-i);
                break;
            }
            
        }
        return garland;
    }
}