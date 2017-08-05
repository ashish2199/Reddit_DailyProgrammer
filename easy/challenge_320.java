package easy;

import java.util.Scanner;

/**
 *
 * @author Ashish
* [2017-06-19] Challenge #320 [Easy] Spiral Ascension
* 
* The user enters a number. Make a spiral that begins with 1 and starts from the
* top left, going towards the right, and ends with the square of that number.
* 
*/
public class challenge_320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        int xdir=1;
        int ydir=1;
        boolean run = true;
        int x=0,y=0;
        int cnt =1;
        
        int i=0,steps=0;
        int s=n;
        while(run){
            if(steps==s){
                if(i==0){s=s-1;--x;++y;}
                if(i==1){--y;--x;}
                if(i==2){s=s-1;++x;--y;}
                if(i==3){++y;++x;}
                i=(i+1)%4;
                steps=0;
            }
            //System.out.println("y="+y+" x="+x+" steps="+steps+" s="+s+" i="+i);
            a[y][x]=cnt;
            cnt++;
            steps++;
            if(i==0){xdir=1;ydir=0;}
            if(i==1){xdir=0;ydir=1;}
            if(i==2){xdir=-1;ydir=0;}
            if(i==3){xdir=0;ydir=-1;}
            x += xdir;
            y += ydir;
            if(cnt-1==n*n){run=false;}
        }
        print(a);
    }
    static void print(int a[][]) {
        System.out.println("\n");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf(" %3d", a[i][j]);

            }
            System.out.println("");
        }
    }
}
