package easy;

import java.util.Arrays;
import java.util.Scanner;
/*
[2015-06-22] Challenge #220 [Easy] Mangling sentences
take a sentence and mangle it up by sorting the letters in each word. So, for 
instance, if you take the word "hello" and sort the letters in it, you get "ehllo".
If you take the two words "hello world", and sort the letters in each word, you get "ehllo dlorw".

There are more things between heaven and earth, Horatio, than are dreamt of in your philosophy. 
Eehrt aer emor ghinst beeentw aeehnv adn aehrt, Ahioort, ahnt aer ademrt fo in oruy hhilooppsy.
*/
public class challenge_220{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String words[]=input.split(" ");
        for(String w:words){
            System.out.print(sort(w)+" ");
        }
        System.out.println("");
    }
    
    static String sort(String word){
        
        String sorted_word="";
        
        boolean is_first_letter_capital =Character.isUpperCase(word.charAt(0));
        
        String lowercase_word=Character.toLowerCase(word.charAt(0))+word.substring(1);
        
        //replace alphabets with spaces so that it can be used to keep track of postition of puntuation
        // "aren't" will get converted to "    ' "
        String with_punctuations=lowercase_word.replaceAll("[A-Za-z]"," ");
        
        
        String without_punctuations=lowercase_word.replaceAll("[,.!?\\\'-]","");
        
        String letters[]=without_punctuations.split("");
        
        Arrays.sort(letters);
        
        if(is_first_letter_capital){
            //make first letter capital
            letters[0]=""+Character.toUpperCase(letters[0].charAt(0));
        }
        
        //substitute with letter where there is space and if a punctuation is found then add that instead.
        for(int i=0,m=0;i<lowercase_word.length();i++){
            if( with_punctuations.charAt(i)==' ' )
            {
                sorted_word += letters[i-m]; 
            }
            else{
                sorted_word += with_punctuations.charAt(i);
                m++;
            }
        }
        //System.out.println("result is "+sorted_word);
        
        return sorted_word;
    }
}