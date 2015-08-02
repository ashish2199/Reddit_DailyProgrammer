package intermediate;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class challenge_219{
    
    static ArrayList<item> todo_list = new ArrayList<>();
    
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            
        String inp = sc.nextLine();
        // ['][^']*[,']
        
        Pattern pattern =Pattern.compile("[\'][^\']*[\']");

        Matcher matcher = pattern.matcher(inp);

        boolean found = false;
        
        
            
            if(inp.startsWith("addItem('")){
                ArrayList<String> params = new ArrayList();
                String value="";
                boolean start = true;
                while (matcher.find()) {
                    String parameter = inp.substring(matcher.start()+1, matcher.end()-1);
                    if(start){
                        value=parameter;
                        start=false;
                    }
                    else{
                        params.add(parameter);
                        
                    }
                }

                add_to_list(value, params);
            }

            if(inp.startsWith("viewList('")){
                ArrayList<String> params = new ArrayList();

                while (matcher.find()) {
                    String parameter = inp.substring(matcher.start()+1, matcher.end()-1);

                    params.add(parameter);

                }

                view_list(params);
            }

            if(inp.startsWith("updateItem('")){

                ArrayList<String> params = new ArrayList();
                while (matcher.find()) {
                    String parameter = inp.substring(matcher.start()+1, matcher.end()-1);

                    params.add(parameter);

                }

                edit_item( params.get(0), params.get(1) );
            }
        }
    }
    
    static void add_to_list(String value,ArrayList<String>  categories){
        item e = new item(value,categories);
        todo_list.add(e);
    }
    static void remove_from_list(){
        Iterator it =todo_list.iterator();
        while(it.hasNext()){
            item e = (item)it.next();
            todo_list.remove(e);
        }
    }
    static void edit_item(String oldValue,String newValue){
        Iterator it =todo_list.iterator();
        while(it.hasNext()){
            item e = (item)it.next();
            if(e.contents.equals(oldValue)){
                e.contents=newValue;
            }
        }
    }
    
    static void view_list(ArrayList<String> categories){
        
        Iterator it =todo_list.iterator();

        System.out.print("---- ");
            for(String c:categories){
            
                System.out.print(""+c+"");
                if(categories.indexOf(c)!=(categories.size()-1) ){
                    System.out.print(" & ");
                }
            }
        System.out.println(" ----");
        
        while(it.hasNext()){
            item e = (item)it.next();
            boolean valid = true;
            for(String c:categories){
                if(!e.category.contains(c)){
                    valid=false;
                }
            }
            if(valid){
                System.out.println("- "+e.contents);
            }
        }
    }
    
}
class item {
    public ArrayList<String> category = new ArrayList<>();
    public String contents;
    public item(String value,ArrayList<String> categories){
        this.contents=value;
        for(String c:categories){
            this.category.add(c);
        }
    }
}