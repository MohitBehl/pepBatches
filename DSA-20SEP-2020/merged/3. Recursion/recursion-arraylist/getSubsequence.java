import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String ques) {
        if(ques.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        ArrayList<String> list = gss(roq);
        ArrayList<String> mylist = new ArrayList<String>();
        
        // add elements of list->mylist(as it is) 
        for(String s : list){
            mylist.add(s);
        }
        
        // add elements of list->mylist(ch+ele) 
        for(String s : list){
            mylist.add(ch+s);
        }
        
        return mylist;
    }

}