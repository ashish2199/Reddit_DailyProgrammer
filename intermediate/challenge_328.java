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
        int py[][]=new int[n][];
        for (int i = 0; i < n; i++) {
            String s[] = sc.nextLine().split(" ");
            py[i]=new int[s.length];
            for (int j = 0; j < s.length; j++) {
                int num = Integer.parseInt(s[j]);
                py[i][j]=num;
            }
        }
        int sum =0;
        for (int i = py.length-2; i >= 0; i--) {
            for (int k = 0; k < py[i].length; k++) {
                py[i][k] += Math.min(py[i+1][k], py[i+1][k+1]);
            }
        }
        sum=py[0][0];
        System.out.println(""+sum);
    }
}


























