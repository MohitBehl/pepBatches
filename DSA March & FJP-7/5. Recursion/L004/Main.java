import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        ArrayList<String> res = gss(str);
        System.out.println(res);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = gss(ros);
        ArrayList<String> ans = new ArrayList<>();
        // exc
        for(String ss : rres){
            ans.add(ss);
        }

        // inc
        for(String ss : rres){
            ans.add(ch + ss);
        }

        return ans;
    }

}