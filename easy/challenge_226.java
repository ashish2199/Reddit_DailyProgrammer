package easy;
import java.util.Scanner;
public class challenge_226{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        fraction result=new fraction("0/1");
        while(n-->0){
            String inp = sc.nextLine();
            fraction f = new fraction(inp);
            result = result.add(f);
            result.proper_form();
            System.out.println("adding "+n+"");
            result.print();
            System.out.println("\n\n");
        }
        System.out.println("The answer is");
        result.print();
        System.out.println("");
        
        
    }
}
class fraction {
    long numerator,denominator;
    fraction(long numerator,long denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }
    fraction(String s){
        String inp[]=s.split("/");
        this.numerator=Long.parseLong(inp[0]);
        this.denominator=Long.parseLong(inp[1]);
    }
    
    fraction add(fraction fr){
        if( fr.numerator==0 && fr.denominator == 1 ){
            return this;
        }
        long new_denom = this.denominator*fr.denominator;
        long factor_this = new_denom/this.denominator;
        long factor_fr = new_denom/fr.denominator;
        long new_numer= this.numerator*factor_this+fr.numerator*factor_fr;
        fraction f = new fraction(new_numer,new_denom);
        return f;
    }
    
    void proper_form(){
        for_loop:for (long i = 2; ( i <= this.denominator && i <= this.numerator ); i++) {
            while( this.numerator%i==0 && this.denominator%i==0 ){
                
                this.numerator=this.numerator/i;
                this.denominator=this.denominator/i;
                
                if(this.numerator==1){
                    break for_loop;
                }
            }
        }
    }
    
    void print(){
        System.out.print(""+this.numerator+"/"+this.denominator);
    }
}