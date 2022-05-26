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

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myPath = new ArrayList<>();
        if(n >= 1){
            // 1 step 
            ArrayList<String> path1Step = getStairPaths(n-1);
            for(String path : path1Step){
                myPath.add('1'+path);
            }
        }
        if(n >= 2){
            // 2 step 
            ArrayList<String> path2Step = getStairPaths(n-2);
            for(String path : path2Step){
                myPath.add('2'+path);
            }
        }
        if(n >= 3){
            // 3 step 
            ArrayList<String> path3Step = getStairPaths(n-3);
            for(String path : path3Step){
                myPath.add('3'+path);
            }
        }
        return myPath;
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) { // invalid
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        if(sr == dr && sc == dc){ // valid
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> hpath = getMazePaths(sr, sc+1, dr, dc);// h
        ArrayList<String> vpath = getMazePaths(sr+1, sc, dr, dc);// v

        ArrayList<String> path = new ArrayList<>();
        for(String p : hpath){
            path.add("h"+p);
        }
        for(String p : vpath){
            path.add("v"+p);
        }
        return path;
    }
}