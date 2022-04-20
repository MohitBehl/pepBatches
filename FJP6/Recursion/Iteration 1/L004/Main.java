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
}
