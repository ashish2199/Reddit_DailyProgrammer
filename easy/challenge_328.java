package easy;
import java.util.Scanner;
/**
 * @author ashish.padalkar
 * 

[17-08-21] Challenge #328 [Easy] Latin Squares
 
A Latin square is an n × n array filled with n different symbols, each occurring exactly once in each row and exactly once in each column.
For example:
1
And,
1 2
2 1
Another one,
1 2 3
3 1 2
2 3 1

Input Description
Let the user enter the length of the array followed by n x n numbers. Fill an array from left to right starting from above.

* Output Description
If it is a Latin square, then display true. Else, display false.
*/
public class challenge_328 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int a[][]=new int[n][n];
        String arr = sc.nextLine();
        String nums[]=arr.split(" ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int k = Integer.parseInt(nums[i*n+j]);
                a[i][j]=k;
            }
        }
        System.out.println(""+isLatinSquare(a));
    }
    public static boolean isLatinSquare(int a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int num = a[i][j];
                for (int k = 0; k < a.length; k++) {
                    //row
                    if( a[i][k]==num && k!=j ){
                        return false;
                    }
                    //Column
                    if( a[k][j]==num && k!=i ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
