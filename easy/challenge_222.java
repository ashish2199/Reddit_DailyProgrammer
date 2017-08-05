package easy;

import java.util.Scanner;
/*

[2015-07-06] Challenge #222 [Easy] Balancing Words

Description
Today we're going to balance words on one of the letters in them. We'll use the 
position and letter itself to calculate the weight around the balance point. 
A word can be balanced if the weight on either side of the balance point is equal. 
Not all words can be balanced, but those that can are interesting for this challenge.
The formula to calculate the weight of the word is to look at the letter position 
in the English alphabet (so A=1, B=2, C=3 ... Z=26) as the letter weight, then 
multiply that by the distance from the balance point, so the first letter away 
is multiplied by 1, the second away by 2, etc.
As an example:
STEAD balances at T: 1 * S(19) = 1 * E(5) + 2 * A(1) + 3 * D(4))
Input Description
*/
public class challenge_222{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        
        str=str.toUpperCase();
        
        String lhs="",rhs="";
        
        int lhs_weight=0,rhs_weight=0;
        
        boolean balanced = false;
        
        int i=0;
        
        for (i = 0; i < str.length()-2; i++) {
            lhs = str.substring(0, i+1);
            rhs = str.substring(i+2);
            
            lhs_weight=find_lhs_weight(lhs);
            rhs_weight=find_rhs_weight(rhs);
            
            if(lhs_weight==rhs_weight){
                balanced=true;
                break;
            }
        }
        
        if(balanced){
            System.out.println(lhs+" "+str.charAt(i+1)+" "+rhs+"  "+lhs_weight);
        }
        else{
            System.out.println(str+" DOES NOT BALANCE");
        }
        
    }
    
    static public int find_lhs_weight(String inp){
        int weight =0;
        for ( int i = 0; i < inp.length(); i++ ) {
            int distance = inp.length()-i;
            
            char c = inp.charAt(i);
            
            //get ascii value
            int value = c;
            value -= 64;
            
            weight += value*distance;
        
        }
        
        return weight;
    }
    
    static public int find_rhs_weight(String inp){
        int weight =0;
        for ( int i = 0; i < inp.length(); i++ ) {
            int distance = i+1;
            
            char c = inp.charAt(i);
            
            //get ascii value
            int value = c;
            value -= 64;
            
            weight += value*distance;
        
        }
        
        return weight;
    }
}