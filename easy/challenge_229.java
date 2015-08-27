    package easy;

    import java.util.Scanner;

    public class challenge_229{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a number to find out the fixed point of cos(x)");
            double a = sc.nextDouble();
            System.out.println("Enter 2 to find out the fixed point of f(x) = x - tan(x)");
            double b = sc.nextDouble();
            System.out.println("Enter a number to find out the fixed point of f(x) = 1 + 1/x");
            double c = sc.nextDouble();
            System.out.println("Enter a number between 0 and 1 to find out the fixed point of f(x) = 4x(1-x)");
            double d = sc.nextDouble();
            System.out.println("Enter the number of iteration you want say 100 ");
            int k = sc.nextInt();
            int m = 0;
            while(m < k ){
                a = Math.cos(a);
                b = b - Math.tan(b);
                c = 1+(1/c);
                d = 4*d*(1-d);
                m++;
            }
            System.out.println("The fixed point of cos(x) is "+a);
            System.out.println("The fixed point of f(x) = x - tan(x) is "+b);
            System.out.println("The fixed point of f(x) = 1 + 1/x is "+c);
            System.out.println("The fixed point of f(x) = 4x(1-x) is "+d);

        }
    }


