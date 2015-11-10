package easy;
import java.util.*;
/*
[2015-10-12] Challenge #236 [Easy] Random Bag System
*/
public class challenge_236 {
    public static void main(String[] args) {
        printRandomSequence();
    }

    public static void printRandomSequence() {
        for (int i = 0; i < 7; i++) {
            String s = new String(generateRandomArray());
            System.out.print(""+s);
        }
        String s = new String(generateRandomArray());
        int r = rand.nextInt(7);
        System.out.println(""+s.charAt(r));
    }
    
    static Random rand = new Random();
    
    static char[] generateRandomArray(){
        char a[]=new char[7];
        
        a[0]='O';
        a[1]='I';
        a[2]='S';
        a[3]='Z';
        a[4]='L';
        a[5]='J';
        a[6]='T';

        /*
        Fisher–Yates shuffle algorithm
        for i from 0 to n − 2 do
            j ← random integer such that i ≤ j < n
            exchange a[j] and a[i]
        */
        for (int i = 0; i < a.length-3; i++) {
            int min = i;
            int max = a.length;
            
            int r = rand.nextInt((max - min)) + min;
            swap(a,i,r);
        }
        return a;
    }
    
    static void swap(char a[],int p,int q){
                    char temp = a[p];
                    a[p]=a[q];
                    a[q]=temp;
    }
}    
