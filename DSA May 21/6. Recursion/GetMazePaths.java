import java.util.*;

public class GetMazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        ArrayList<String> list = getMazePaths(0,0,nr-1,nc-1);
    
        System.out.println(list);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            return new ArrayList<String>();
        }
        if(sr == dr && sc == dc){
            ArrayList<String> myPath = new ArrayList<>();
            myPath.add("");
            return myPath;
        }
        ArrayList<String> HPath = getMazePaths(sr,sc+1,dr,dc);
        ArrayList<String> VPath = getMazePaths(sr+1,sc,dr,dc);
        
        ArrayList<String> myPath = new ArrayList<>();
        for(String path : HPath){
            myPath.add('h'+path);
        }
        for(String path : VPath){
            myPath.add('v'+path);
        }
        return myPath;
    }

}