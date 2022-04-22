import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // ArrayList<String> res = getStairPaths(3);        
        // System.out.println(res);
        ArrayList<String> res = getMazePath(0, 0, 2, 2);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n){
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(n < 0){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> mylist = new ArrayList<>();
        ArrayList<String> path1Len = getStairPaths(n-1);
        ArrayList<String> path2Len = getStairPaths(n-2);
        ArrayList<String> path3Len = getStairPaths(n-3);

        for(String path : path1Len){
            mylist.add(1+path);
        }
        for(String path : path2Len){
            mylist.add(2+path);
        }
        for(String path : path3Len){
            mylist.add(3+path);
        }
        return mylist;
    }

    public static ArrayList<String> getMazePath(int r,int c,int dr,int dc){
        if(r == dr && c == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(r  > dr || c > dc){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        ArrayList<String> hPath = getMazePath(r, c+1, dr, dc);// H movement
        ArrayList<String> vPath = getMazePath(r+1, c, dr, dc);// V movement

        ArrayList<String> myPath = new ArrayList<>();
        for(String path : hPath){
            myPath.add("h"+path);
        }
        for(String path : vPath){
            myPath.add("v"+path);
        }
        return myPath;
    }
}
