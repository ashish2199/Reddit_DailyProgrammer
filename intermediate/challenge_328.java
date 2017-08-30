/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import java.util.Scanner;

/**
 *
 * @author ashish.padalkar
 */

public class challenge_328 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int py[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            String s[] = sc.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int num = Integer.parseInt(s[j]);
                py[i][j]=num;
            }
        }
        int sum =py[0][0];
        int j=0;
        for (int i = 1; i < py.length; i++) {
            int c=0;
            if(py[i][j]<py[i][j+1]){
                c =py[i][j];
            }else{
                c = py[i][j+1];
                j+=1;
            }
            sum +=c;
            System.out.print("  "+c);
        }
        System.out.println("\n"+sum);
    }
    /*
447


15
75
95 64
17 47 82
18 35 87 10
20 4 82 47 65
19 1 23 75 3 34
88 2 77 73 7 63 67
99 65 4 28 6 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 4 68 89 53 67 30 73 16 69 87 40 31
4 62 98 27 23 9 70 98 73 93 38 53 60 4 23
*/
}


























