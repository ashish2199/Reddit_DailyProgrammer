/*
[2015-06-29] Challenge #221 [Easy] Word snake

Inmput  single line of words (written in ALL CAPS). The last letter of each word 
        will be the first letter in the next.

*/
package easy;
import java.util.Scanner;
public class challenge_221{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
            String inp = sc.nextLine();
            String words[]=inp.split(" ");
            System.out.println("inp = "+words);
            int space=0;
            System.out.print(""+words[0].charAt(0));
            for(int i =0;i<words.length;i++){
                if(i%2==0){
                    //print horizontally
                    
                    //we donot start from first char as it has been already printed
                    for(int horizontal=1;horizontal<words[i].length();horizontal++){
                            System.out.print(""+words[i].charAt(horizontal));
                    }
                    System.out.println("");
                    
                    //since we printed only length-2 chars so 
                    space += (words[i].length()-2);
                    
                    // at starting increment space
                    if(i==0){space++;}
                }
                else{
                    
                    // print vertically 
                    
                    for(int vertical=1;vertical<words[i].length();vertical++){
                            
                            //add spacing before the word
                            for(int j=0;j<space;j++){   
                                System.out.print(" ");
                            }
                        
                            //print that character
                            System.out.print(""+words[i].charAt(vertical));
                            
                            /*
                            if last char then donot make a line break as we 
                            will start from there only no need to break line
                            */
                            if( vertical!= (words[i].length()-1) ){
                                System.out.println("");
                            }
                    }
                    
                    //increment the spacing only after all vertical characters have been printed
                    space++;
                }
                
            }
            
            // line break after snake has been printed1
            System.out.println("");
        
    }
}