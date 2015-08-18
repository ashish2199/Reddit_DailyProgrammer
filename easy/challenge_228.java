    package easy;
    import java.util.Scanner;
    public class challenge_228{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            while(true){
                String inp = sc.nextLine();

                //use string literal first instad of variable so as to avoid the 
                //situation where the variable is null
                if("exit".equals(inp)){
                    System.exit(0);
                }
                boolean order = checkOrder(inp);
            }


        }

        static boolean checkOrder(String s){
           char[] c=s.toCharArray();
           int j=c[0],k;

           //we assume that there is order in the string at the starting
           boolean order=true;

           //check for order
           for(int i =1;i<c.length-1;i++){
               k=c[i];
               if(j>k){
                   //not in order
                   order = false;
                   break;
               }
           }

           if(order == true){
               System.out.println(s+" IN ORDER");
               return true;
           }
           //reinitialise so that we can use the same logic again but this time 
           //to find the reverse instead
           order = true;
           j=c[0];
           for(int i =1;i<c.length-1;i++){
               k=c[i];
               if(j<k){
                   order = false;
                   break;
               }
           }
           if(order == true){
               System.out.println(s+" IN REVERSE ORDER");
               return true;
           }

           System.out.println(s+" NOT IN ORDER");
           return false; 
        }
    }

