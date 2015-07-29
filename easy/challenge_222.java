package easy;

import java.util.Scanner;

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