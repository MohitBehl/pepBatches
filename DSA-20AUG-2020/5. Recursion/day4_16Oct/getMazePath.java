import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        System.out.println(getMazePaths1(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    // public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    //     if(sr > dr || sc > dc){
    //         // invalid index
    //         ArrayList<String> base = new ArrayList<String>();
    //         return base;
    //     }
        
        
    //     if(sr == dr && sc == dc){
    //         // dest reached
    //         ArrayList<String> base = new ArrayList<String>();
    //         base.add("");
    //         return base;
    //     }
        
    //     ArrayList<String> hPaths = getMazePaths(sr,sc+1,dr,dc);
    //     ArrayList<String> vPaths = getMazePaths(sr+1,sc,dr,dc);
        
    //     ArrayList<String> myPaths = new ArrayList<String>();
        
    //     for(String s : hPaths){
    //         myPaths.add('h'+s);
    //     }
        
    //     for(String s : vPaths){
    //         myPaths.add('v'+s);
    //     }
        
    //     return myPaths;
    // }

    public static ArrayList<String> getMazePaths1(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            // dest reached
            ArrayList<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        
        ArrayList<String> myPaths = new ArrayList<String>();
        
        if(sc+1 <= dc){
            ArrayList<String> hPaths = getMazePaths1(sr,sc+1,dr,dc);
            for(String s : hPaths){
                myPaths.add('h'+s);
            }
        }
        
        if(sr+1 <= dr){
            ArrayList<String> vPaths = getMazePaths1(sr+1,sc,dr,dc);
            for(String s : vPaths){
                myPaths.add('v'+s);
            }
        }
        
        return myPaths;
    }
}