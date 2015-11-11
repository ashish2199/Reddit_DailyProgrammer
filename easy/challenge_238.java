    package easy;
    import java.util.Scanner;
    import java.util.Random;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
    /*
        [2015-10-26] Challenge #238 [Easy] Consonants and Vowels
    */
    public class challenge_238 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            Pattern pattern = Pattern.compile("[^cCvV]");

            Matcher matcher =pattern.matcher(input);

            if(!matcher.find()){
                String c="bcdfghjklmnpqrstvwxyz";
                String v="aeiou";
                String C = c.toUpperCase();
                String V = c.toUpperCase();

                Random ran = new Random();
                for (int i = 0; i < input.length(); i++){
                    if(input.charAt(i)=='c'){
                        int r=ran.nextInt(21);
                        System.out.print(""+c.charAt(r));
                    }
                    if(input.charAt(i)=='C'){
                        int r=ran.nextInt(21);
                        System.out.print(""+C.charAt(r));
                    }
                    if(input.charAt(i)=='v'){
                        int r=ran.nextInt(5);
                        System.out.print(""+v.charAt(r));
                    }
                    if(input.charAt(i)=='V'){
                        int r=ran.nextInt(5);
                        System.out.print(""+V.charAt(r));
                    }
                }
            }
            else{
                System.out.println("Please enter a correct pattern");
            }

        }
    }
