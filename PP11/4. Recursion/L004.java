import java.io.*;
import java.util.*;

public class L004 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> list = getStairPaths(n);
        System.out.println(list);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(n < 0){
            ArrayList<String> base = new ArrayList<>();
            
            return base;
        }
        ArrayList<String> mypath = new ArrayList<>();
        
        ArrayList<String> path1len = getStairPaths(n-1);// 1 len 
        for(String path : path1len){
            mypath.add("1"+path);
        }
        
        ArrayList<String> path2len = getStairPaths(n-2);// 2 len
        for(String path : path2len){
            mypath.add("2"+path);
        }
        
        ArrayList<String> path3len = getStairPaths(n-3);// 3 len
        for(String path : path3len){
            mypath.add("3"+path);
        }
        
        return mypath;
    }

    public static String keypad[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        String roq = str.substring(1);
        ArrayList<String> rres = getKPC(roq);
        String word = keypad[Integer.parseInt(str.charAt(0)+"")];
        ArrayList<String> list = new ArrayList<>();
        for(int idx = 0 ; idx < word.length() ; idx++){
            for(String comb : rres){
                list.add(word.charAt(idx)+comb);
            }
        }
        return list;
    }

    public static void printSS(String ques, String asf) {
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        printSS(roq,asf+ch);
        printSS(roq,asf);
    }

    public static void printStairPaths(int n, String path) {
        if(n == 0){
            System.out.println(path);
            return;
        }
        
        if(n-1 >= 0){
            printStairPaths(n-1,path+"1");
        }
        
        if(n-2 >= 0){
            printStairPaths(n-2,path+"2");
        }
        
        if(n-3 >= 0){
            printStairPaths(n-3,path+"3");
        }
    }

    
}