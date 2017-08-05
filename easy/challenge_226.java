package easy;

import java.util.Scanner;

/*
[2015-08-03] Challenge #226 [Easy] Adding fractions
The output will be a single line, containing the resulting fraction reduced so that the numerator and denominator has no factors in common.
*/
public class challenge_226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Fraction result = new Fraction("0/1");
        while (n-- > 0) {
            String inp = sc.nextLine();
            Fraction f = new Fraction(inp);
            result = result.add(f);
            result.toProperForm();
        }
        System.out.println("\nThe answer is  " + result.toString());

    }
}

class Fraction {

    long numerator, denominator;

    Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Fraction(String s) {
        String inp[] = s.split("/");
        this.numerator = Long.parseLong(inp[0]);
        this.denominator = Long.parseLong(inp[1]);
    }

    Fraction add(Fraction fr) {
        //if we are trying to add 0 then return the Fraction itself
        if (fr.numerator == 0) {
            return this;
        }
        long new_Denominator = this.denominator * fr.denominator;
        long factor_This = new_Denominator / this.denominator;
        long factor_Fr = new_Denominator / fr.denominator;
        long new_Numerator = this.numerator * factor_This + fr.numerator * factor_Fr;
        Fraction f = new Fraction(new_Numerator, new_Denominator);
        return f;
    }

    void toProperForm() {
        //There cannot be a factor greater than the square root of number
        for_loop:
        for (long i = 2; (i <= Math.sqrt(this.denominator) && i <= Math.sqrt(this.numerator)); i++) {

            while (this.numerator % i == 0 && this.denominator % i == 0) {

                this.numerator = this.numerator / i;
                this.denominator = this.denominator / i;

                if (this.numerator == 1) {
                    break for_loop;
                }
            }
        }
    }

    @Override
    public String toString() {
        String fr = this.numerator + "/" + this.denominator;
        return fr;
    }
}
