package easy;
    import java.util.Scanner;
    /*
        [2016-02-16] Challenge #254 [Easy] Atbash Cipher

        Things that I learned about :

        1.Atbash Cipher -  A simple monoalphabetic substitution cipher.
        Working: It works by substituting the first letter of an alphabet 
        for the last letter, the second letter for the second to last and so on, 
        effectively reversing the alphabet.
        eg. 'abcxyz'=>'zxycba'

        2.we can compare char directly with char literal instead of converting char
        into its decimal equivalent and then comparing the ascii code.
        so we can compare char C with 'a' as C>='a'

        3.In java we can calculate decimal equivalent of a char C by finding the 
        C - 'a' this would give a integer in the range [0,25] 0 for A and Z for 25.


        Programming concepts used:
        *for each loop
        *else if ladder
        *ascii equivalent of chars

    */
    public class challenge_254{
            public static void main(String args[]){
                    Scanner sc = new Scanner(System.in);
                    String input = sc.nextLine();
                    String output = cipher(input);
                    System.out.println(""+output);
            }
            static String cipher(String input){
                    char letters[] = input.toCharArray();
                    String output="";
                    for(char c:letters){
                            if(c>='a'&&c<='z'){
                                    c = (char)(c-'a');
                                    c = (char)('z'-c);
                                    output=output+c;
                            }
                            else if(c>='A'&&c<='Z'){
                                    c= (char) ('Z'-(c-'A')); 
                                    output=output+c;
                            }
                            else{
                                    output=output+c;
                            }
                    }
                    return output;
            }
    }