package easy;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * [2016-09-19] Challenge #284 [Easy] Wandering Fingers
 * 
 * You'll be given a string of characters representing the letters the user has dragged their finger over.
 * For example, if the user wants "rest", the string of input characters might be "resdft" or "resert".
 * 
 * Assumptions about the input strings:
 * QWERTY keyboard
 * Lowercase a-z only, no whitespace or punctuation
 * The first and last characters of the input string will always match the first and last characters of the desired output word
 * Don't assume users take the most efficient path between letters
 * Every letter of the output word will appear in the input string
 * Bonus
 * 
 * CHECKS
 * first check if the first and last letter match
 * check if the input string has letters in same sequence as the word being matched
 * 
 * @author ashish.padalkar
 * 
 */



/*
    Learning

    Donot use string concatination when reading from a large file a better approach 
    would be to string buffer or array list otherwise it takes a lot of time as string 
    concatination takes O(M+N) time as compared to O(1) in string buffer

    Also try to avoid printing to console as it also makes the overall operation slow.

    use System.currentTimeMillis() to calculate how much time it takes to call function

    use of conditional breakpoint by right clicking 

*/
public class challenge_284 {
    
    
    public static void main(String[] args) {
        loadFile("enable1.txt");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        checkWord(input);
    }
    static ArrayList<String> words ;
    public static void loadFile(String fileName){
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s,text="";
            
            words = new ArrayList<>();
            
            while( (s = br.readLine())!=null ){
                words.add(s);
            }
        } catch (IOException e) {
            System.out.println("Error in loading File");
            System.err.print("Error in loading file");
        }
    }
    public static void checkWord(String inp){
        
        for (String word : words) {
            if (  (word.charAt(0)!=inp.charAt(0)) || ( word.charAt(word.length()-1) != inp.charAt(inp.length()-1) )  ) {
                continue;
            }
            else{
                //System.out.println("Checking for "+word);
                int pw=0;
                int pi=0;
                for (int i = 0; i < inp.length(); i++){
                    if(pw==word.length()){
                        break;
                    }
                    if(word.charAt(pw)==inp.charAt(pi)){
                        int prev_pw=pw;
                        pi++;
                        pw++;
                        
                        if(pw!=word.length()){
                            while( (pw!=word.length()) && word.charAt(prev_pw)==word.charAt(pw) ){
                                pw++;
                            }
                        }
                    }
                    else{
                        pi++;
                    }
                }
                if( pw==word.length() && word.length()>=5){
                    System.out.println(""+word);
                }
            }
        }
    }
}