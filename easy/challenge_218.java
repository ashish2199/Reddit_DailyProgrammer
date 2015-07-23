package easy;
import java.math.BigInteger;
import java.util.Scanner;
public class challenge_218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int inp = sc.nextInt();
        int steps = 0;
        
        //converts int to num
        BigInteger num = new BigInteger(""+inp);
        
        //while(num!=reverse(num)){
        while(num.compareTo(reverse(num))!=0){
            
            //num = num + reverse(num);
            num = num.add(reverse(num));
            
            steps++;
            System.out.println("step:"+steps+" now the num is"+num);
        }
        System.out.println(inp+"  gets palindromic after "+steps+" steps: "+num);
        
        //find_same_palindromic_number();
        
        //find_maxstep_palindromic_number();
    }
    
    //Bonus 1
    static void find_same_palindromic_number(){
        
        BigInteger[] values=new BigInteger[1001];
        for (int i = 0; i < 1000; i++) {
            values[i]=find_palindromic_number(new BigInteger(""+i),1000);
            //System.out.println("The value of "+i+"'s palindromic number is "+values[i].toString());
        }
        
        linear_search(values);
        
    }
    
    static void linear_search(BigInteger[] values){
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                //i<j to avoid repeatitions
                if(i!=j&&(i<j)){
                    if( values[i].compareTo( BigInteger.ZERO ) != 0    ){
                        if( values[i].compareTo( values[j] ) == 0    ){
                            System.out.println("The values"+i+" and "+j+" have same palindromic numbers");
                        }
                    }
                }
            }
        }
    }
    
    
    //Bonus 2
    static void find_maxstep_palindromic_number(){
        BigInteger value=new BigInteger("0");
        for (int i = 0; i < 1000; i++) {
                value=find_Lychrel_palindromic_number(new BigInteger(""+i),10000);
                if(value.compareTo(BigInteger.ZERO)!=0){
                    
                System.out.println("Lychrel's palindromic number is "+i);
                
                }
        }
    }
    
    static BigInteger find_Lychrel_palindromic_number(BigInteger num,int max_steps){
        BigInteger initial_value=num;
        long steps=0;
        while(num.compareTo(reverse_fast(num))!=0){
            
            //num = num + reverse(num);
            num = num.add(reverse_fast(num));
            
            if(steps>max_steps){
                return num;
            }
            steps++;
            //System.out.println(" now the num is"+num);
        }
        //System.out.println(initial_value.toString()+" returned 0");
        return BigInteger.ZERO;
    }
    
    
    static BigInteger find_palindromic_number(BigInteger num,int max_steps){
        long steps=0;
        while(num.compareTo(reverse_fast(num))!=0){
            
            //num = num + reverse(num);
            num = num.add(reverse_fast(num));
            if(steps>max_steps){
            num=BigInteger.ZERO;
            break;
            }
            steps++;
            //System.out.println(" now the num is"+num);
        }
        return num;
    }
    
    
    static BigInteger reverse(BigInteger num){
        BigInteger rev_num = new BigInteger("0");
        
        //while(num>0){
        while(num.compareTo(BigInteger.ZERO)==1){
            
            //rev_num=rev_num*10+(num%10);
            rev_num=(rev_num.multiply(BigInteger.TEN)).add(num.mod(BigInteger.TEN));
            
            //num=num/10;
            num=num.divide(BigInteger.TEN);
            
        }    
        return rev_num;
    }
    
    static BigInteger reverse_fast(BigInteger num){
        StringBuilder sb = new StringBuilder(num.toString());
        sb.reverse();
        BigInteger rev_num = new BigInteger(sb.toString());
        //System.out.println("the reverse is"+rev_num.toString());
        return rev_num;
    }
    
}
