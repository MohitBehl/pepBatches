import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        ArrayList<String> res = getSS(s);
        System.out.println(res);

    }
    public static ArrayList<String> getSS(String s){
        if(s.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        String res = s.substring(1);
        char ch = s.charAt(0);
        ArrayList<String> rres = getSS(res);

        ArrayList<String> myList = new ArrayList<>();
        // exc
        for(String str : rres){
            myList.add(str);
        }
        // inc
        for(String str : rres){
            myList.add(ch+str);
        }

        return myList;
    }

    public static ArrayList<String> getStairPath(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myList = new ArrayList<>();
        if(n >= 1){ // 1 len 
            ArrayList<String> paths = getStairPath(n-1);
            for(String path : paths){
                myList.add(1+path);
            }
        }

        if(n >= 2){ // 2 len 
            ArrayList<String> paths = getStairPath(n-2);
            for(String path : paths){
                myList.add(2+path);
            }
        }

        if(n >= 3){ // 3 len 
            ArrayList<String> paths = getStairPath(n-3);
            for(String path : paths){
                myList.add(3+path);
            }
        }

        return myList;
    }
}
