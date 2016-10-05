package easy;

import java.util.Scanner;
/*
Use long as datatype and Long.parseLong() for the large numeric values
Dont always go ahead with the first approach that comes into your mind
*/
public class challenge_286 {
    
    /*    
        
        Your program should report what each number is as a factorial, or "NONE"
        if it's not legitimately a factorial. Examples:
        120 = 5!
        150   NONE
        
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        long inp = Long.parseLong(input);
        String output = checkReverseFact(inp);
        System.out.println(""+output);
    }
    //O(n^2)
    public static String checkReverseFactorial(long n){
        int b=0;
        if(n==0){return "0";}
        for (int j = 1; j <= n; j++) {
            //System.out.println("checking for "+j);
            double f=n;
            double k=j;
            while(k>=1){
                f=f/k;
                --k;
            }
            if(f==1){
                b=j;
                break;
            }
        }
        if(b!=0){
            return ""+b;
        }
        else{
            return "NONE";
        }
    }
    
    //O(N)
    public static String checkReverseFact(long n){
        int i = 2;
        String s="";
        while ( n % i == 0){
                n /= i;
                i++;
        }
        if(n > 1)
                s="NONE";
        else
                s=""+(i-1);
        return s;
    }
}
