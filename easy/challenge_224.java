package easy;
import java.util.Random;
import java.util.Scanner;
public class challenge_224{
    
    public static void main(String... args){
        
        Scanner sc = new Scanner(System.in);
        
        String inp = sc.nextLine();
        String words[] = inp.split(" ");
        
        Random r = new Random();
        
        String[] shuffled_word = shuffle(words);
        
        for(String s:shuffled_word){
            System.out.print(s+" ");
        }
        System.out.println("");
    
    }
    
    /*
    Algorithm used for shuffling
    To shuffle an array a of n elements (indices 0..n-1):
        for i from 0 to n − 2 do
            j ← random integer such that i ≤ j < n
            exchange a[j] and a[i]
    
    */
    
    static String[] shuffle(String[] a){
        Random r = new Random();
        for (int i = 0; i < a.length-1; i++) {
            int j = get_random_num(i, a.length, r);
            String temp = a[j];
            a[j]=a[i];
            a[i]=temp;        
        }
    
        return a;
    }
    
    static int get_random_num(int lowerbound,int upperbound,Random r){
        int ran=-1;
        
        //for lowerbound<=ran<upperbound;
        
        ran = r.nextInt(upperbound);
        ran = (lowerbound+ran)%upperbound;
        
        return ran;
    }
    
}