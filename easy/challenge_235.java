package easy;
import java.util.Scanner;
public class challenge_235{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < length; i++) {
            String inp = sc.nextLine();
            String inpa[]=inp.split(",");
            inpa[0]=inpa[0].substring(1);
            inpa[1]=inpa[1].substring(0,inpa[1].length()-1);
            int a = Integer.parseInt(inpa[0]);
            int b = Integer.parseInt(inpa[1]);
            int factors_a[] = getPrimes(a);
            int factors_b[] = getPrimes(b);
            int sum_a = getSum(factors_a);
            int sum_b = getSum(factors_b);
            
            /*
            System.out.println("");
            print(factors_a);
            System.out.println("");
            print(factors_b);
            */
            
            if(sum_a==sum_b){
                System.out.println("("+a+","+b+") VALID");
            }
            else{
                System.out.println("("+a+","+b+") NOT VALID");
            }
        }
        
    }
    
    /*
        Finds Prime factors of a given number and 
        Stores the number of factors in the first index of array that is a[0]
    */
    static int[] getPrimes(int n){
        int a[]=new int[1000];
        int j=1;
        
        for(int i = 2; i <= n; i++) {
            while(n%i==0){
                n /= i;
                a[j]=i;
                j++;
            }
        }
        a[0]=j;
        return a;
    }
    static int getSum(int a[]){
        int sum = 0;
        for (int i = 1; i < a[0]; i++) {
            // so that only distinct primes are added
            if(a[i]!=a[i+1]){sum += a[i];}
        }
        return sum;
    }
    static void print(int a[]){
        for (int i = 1; i < a[0]; i++) {
            System.out.print(a[i]+" ");
        }
    }
}