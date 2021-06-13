import java.util.*;

public class GetSubSequence {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        ArrayList<String> list = gss(str);
        System.out.println(list);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bList = new ArrayList<>();
            bList.add("");
            return bList;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> rres = gss(roq);
        ArrayList<String> myList = new ArrayList<>();
        // exc
        for(String s : rres){
            myList.add(s);
        }
        // inc
        for(String s : rres){
            myList.add(ch+s);
        }
        return myList;
    }

}