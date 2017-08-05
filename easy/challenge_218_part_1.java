package easy;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/*
[2015-06-15] Challenge #218 [Easy] To-do list (Part 1)

Create a list that should have the following basic functionality
Add an item to the to-do list
Delete a selected item from the to-do list
And obviously, print out the list so I can see what to do!
*/
public class challenge_218_part_1{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
            
            String inp = sc.nextLine();
            
            if(inp.startsWith("addItem('")){
                char a = '\'';
                int start_index=inp.indexOf(a);
                int end_index = inp.lastIndexOf(a);
                String task=inp.substring(start_index+1, end_index);
                add_to_list(task);
            }

            if(inp.startsWith("deleteItem('")){
                char a = '\'';
                int start_index=inp.indexOf(a);
                int end_index = inp.lastIndexOf(a);
                String task=inp.substring(start_index+1, end_index);
                delete_from_list(task);
            }

            if(inp.startsWith("viewList()")){
                System.out.println("The list is");
                view_list();
            }
            
            
            
        }
        
    }

static ArrayList<String> list= new ArrayList<>();
    
    static void add_to_list(String s){
        list.add(s);
    }

    static void delete_from_list(String s){
       list.remove(s);
    }
    
    static void view_list(){
        Iterator it = list.iterator();
        while(it.hasNext()){
            String task = (String) it.next();
            System.out.println(""+task);
        }
    }
    
}



/*
addItem('Take a shower');
addItem('Go to work');
viewList();
*/