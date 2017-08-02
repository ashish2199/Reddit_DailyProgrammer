/*
 [2016-10-10] Challenge #287 [Easy] Kaprekar's Routine
 Given a 4 digit number with or without leading zeros
 1. Find the largest digit
 2. Sort the digits in descending order
 3. Kapkrekar's constand - Given a 4-digit number that has at least two different
 digits, take that number's descending digits, and subtract that number's
 ascending digits. Repeat this till you reach 6174.
 */

/*
 Final makes that we cannot change the variable in the method body.
 Primitives and reference variables cannot be reassigned or modified.

 If you have a final object, you can still change the attributes of the object.
 Final parameter is more useful in case of reference types.

 Arrays.copyOf() is used to copy the array
 */
package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import sun.applet.AppletPanel;

/**
 * @author ashish.padalkar
 */
public class challenge_287 {

    public static void main(String[] args) {
        Integer i = takeInput();
        
        int maxDigit = getMaxDigit(i);
        System.out.println("Largest digit in "+i+" is "+maxDigit);
        int dsc = getDescendingOrder(i);
        System.out.println("Descending order "+dsc);
        int d = getKapkrekasConstant(i);
        System.out.println("Kapkrekar's constant for "+i+" is "+d);
        
    }
    public static void printArray(Integer k[]){
        for (int i = 0; i < k.length; i++) {
            System.out.print(""+k[i]+" ");
        }
    }
    public static Integer takeInput() {
        System.out.println("Enter a 4 digit number");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return Integer.parseInt(s);
    }

    public static Integer[] getDigits(final int i) {
        int k = i;
        int j = 0;
        Integer a[] = new Integer[4];
        while (k > 0) {
            a[j] = k % 10;
            k = k / 10;
            j++;
        }
        if(j<4){
            a[3]=a[2];
            a[2]=a[1];
            a[1]=a[0];
            a[0]=0;
        }
        return a;
    }

    public static int getMaxDigit(Integer i) {
        Integer a[]=getDigits(i);
        Arrays.sort(a);
        return a[3];
    }

    public static Integer getAscendingOrder(Integer i) {
        Integer k[]=getDigits(i);
        Arrays.sort(k);
        return k[0]*1000+k[1]*100+k[2]*10+k[3];
    }

    public static Integer getDescendingOrder(Integer i) {
        Integer k[]=getDigits(i);
        Arrays.sort(k, new reverseComparator());
        return k[0]*1000+k[1]*100+k[2]*10+k[3];
    }
    
    public static int getKapkrekasConstant(Integer d){
        int c=0;
        while(d!=6174){
            int asc = getAscendingOrder(d);
            int dsc = getDescendingOrder(d);
            d=dsc-asc;
            c++;
        }
        return c;
    }

}

class reverseComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2) * -1;
    }
}
