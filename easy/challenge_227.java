    package easy;

    import java.util.Scanner;

    public class challenge_227{
        static int a[][];
        static int s;
        static int n;
        static int x,y;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of grid");
            String inp1 = sc.nextLine();
            s = Integer.parseInt(inp1);
            while(s%2!=1){
                System.out.println("Please enter a odd number only");
                inp1 = sc.nextLine();
                s = Integer.parseInt(inp1);
            }
            a = new int[s][s];
            spiral();

            System.out.println("Enter N or X,Y");
            String inp2 = sc.nextLine();
            if(inp2.contains(" ")){
                String coardinates[] = inp2.split(" ");
                System.out.println("The value of N is");
                x = Integer.parseInt(coardinates[0]);
                y = Integer.parseInt(coardinates[1]);
                System.out.println(""+a[--y][--x]);
            }
            else{
                System.out.println("The coardinates of N are");
                n = Integer.parseInt(inp2);
                find(n);
            }



        }

        static void find(int n){
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if(a[i][j]==n){
                        i++;j++;
                        System.out.println("(y,x)="+"("+j+","+i+")");
                        break;
                    }
                }
            }
        }

        static void spiral(){
            int no_Of_Spirals = s/2;
            int steps = 2;
            int num = 1;
            int x=s/2,y=s/2;
            //increment after use
            a[y][x]=num++;
            //System.out.println(""+x+" "+y+" "+num);
            x++;
            //System.out.println("spiral = "+no_Of_Spirals);

            while(no_Of_Spirals > 0){
                no_Of_Spirals--;
                //up
                for (int i = 0; i < steps; i++) {
                    a[y][x] = num++;
                    y--;
                }
                //bring back y inorder to turn left
                y++;



                //left
                --x;
                for (int i = 0; i < steps; i++) {
                    a[y][x] = num++;
                    x--;
                }
                //bring back y inorder to turn left
                x++;



                //down
                y++;
                for (int i = 0; i < steps; i++) {
                    a[y][x] = num++;
                    y++;
                }
                //bring back y inorder to turn left
                y--;



                //right
                x++;
                for (int i = 0; i < steps; i++) {
                    a[y][x] = num++;
                    x++;
                }


                //we donot need to bring back x now

                steps += 2; 

            }
            //print();
        }
        static void print(){
            System.out.println("\n");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    System.out.printf(" %5d", a[i][j]);

                }
                System.out.println("");
            }
        }
    }


