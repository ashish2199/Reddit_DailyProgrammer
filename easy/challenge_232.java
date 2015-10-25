    package easy;
    import java.util.Scanner;
    public class challenge_232{
        public static void main(String... args){
            Scanner sc = new Scanner(System.in);
            int lines=sc.nextInt();
            sc.nextLine();
            String input="";
            while(lines-->0){
                String s = sc.nextLine();
                input += s;
            }
            input=input.toLowerCase();

            boolean b=isPalindrome(input);

            if(b){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not a Palindrome");
            }
        }
        static boolean isPalindrome(String inp){
            String tmp = new String(inp);
            //System.out.println("tmp="+tmp);
            tmp=tmp.replaceAll("[^a-z]","");
            //System.out.println("newtmp="+tmp);
            StringBuffer sb = new StringBuffer(tmp);
            sb.reverse();
            //System.out.println("sb="+sb.toString());
            if(sb.toString().equals(tmp)){
                return true;
            }
            else{
                return false;
            }
        }
    }