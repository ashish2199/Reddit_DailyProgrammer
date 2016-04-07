package easy;

import java.util.Scanner;

/*
[2016-04-04] Challenge #261 [Easy] verifying 3x3 magic squares

Description

A 3x3 magic square is a 3x3 grid of the numbers 1-9 such that each row, column, and major diagonal adds up to 15. Here's an example:
8 1 6
3 5 7
4 9 2
The major diagonals in this example are 8 + 5 + 2 and 6 + 5 + 4. (Magic squares have appeared here on r/dailyprogrammer before, in #65 [Difficult] in 2012.)
Write a function that, given a grid containing the numbers 1-9, determines whether it's a magic square. Use whatever format you want for the grid, 
such as a 2-dimensional array, or a 1-dimensional array of length 9, or a function that takes 9 arguments. You do not need to parse the grid from the
program's input, but you can if you want to. You don't need to check that each of the 9 numbers appears in the grid: assume this to be true.
*/
public class challenge_261 {
    public static void main(String[] args) {
        int a[][]=getInput();
        System.out.println(""+check(a));
    }
    
    static int[][] getInput(){
        int a[][]=new int[3][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            a[i/3][i%3]=sc.nextInt();
        }
        return a;
    }
    
    static boolean check(int a[][]){
        
        int l=a.length;
        int b=a[0].length;
        boolean checkRows=true;
        boolean checkColumns=true;
        boolean checkDiagnol1=true;
        boolean checkDiagnol2=true;
        
        //check row
        for(int i =0;i<l;i++){
            if(a[0][i]+a[1][i]+a[2][i]!=15){
                checkRows=false;
            }
        }
        //check column
        for(int i =0;i<b;i++){
            if(a[i][0]+a[i][1]+a[i][2]!=15){
                checkColumns=false;
            }
        }
        //check diagnol
        int d1=0;
        for (int i = 0; i < l; i++) {
            d1+=a[i][i];
        }
        if(d1!=15){
            checkDiagnol1=false;
        }
        
        int d2=0;
        for (int i = 0; i < l; i++) {
            d2+=a[i][l-i-1];
        }
        if(d2!=15){
            checkDiagnol2=false;
        }
        
        boolean result = checkRows&checkColumns&checkDiagnol1&checkDiagnol2;
        return result;
    }
}
