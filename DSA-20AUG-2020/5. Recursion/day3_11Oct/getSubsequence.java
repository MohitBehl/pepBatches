import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1); // ros == rest of the string 
        
        ArrayList<String> rres = gss(ros); // subsequences of rest of the string 
        
        ArrayList<String> myList = new ArrayList<String>();
        
        // add every element of rres directly in myList 
        for(String s : rres){
            myList.add(s);
        }
        
        // add every element of rres after appending ch in myList
        for(String s : rres){
            myList.add(ch+s);
        }
        
        return myList;
    }

}