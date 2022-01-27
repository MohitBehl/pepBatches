import java.util.ArrayList;
import java.util.Scanner;

public class L003 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        ArrayList<String> list = gss(str);
        System.out.println(list);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> blist = new ArrayList<>();
            blist.add("");
            
            return blist;

        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> subSeq = gss(roq);
        ArrayList<String> mySubSeq = new ArrayList<>();
        
        for(String s : subSeq){
            mySubSeq.add(s);
        }
        for(String s : subSeq){
            mySubSeq.add(ch+s);
        }
        return mySubSeq;
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> bList = new ArrayList<>();
            bList.add("");
            return bList;
        }
        ArrayList<String> myPath = new ArrayList<>();
        if(sc+1 <= dc){
            ArrayList<String> hPath = getMazePaths(sr,sc+1,dr,dc);
            for(String path : hPath){
                myPath.add("h"+path);
            }
        }
        if(sr+1 <= dr){
            ArrayList<String> vPath = getMazePaths(sr+1,sc,dr,dc);
            for(String path : vPath){
                myPath.add("v"+path);
            }
        }
        return myPath;
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        
        if(arr[idx] == x){
            return idx;
        }else{
            return firstIndex(arr,idx+1,x);
        }
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        int res = lastIndex(arr,idx+1,x);
        
        if(res == -1){
            if(arr[idx] == x){
                return idx;
            }else{
                return -1;
            }
        }
        return res;
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if(idx == arr.length){
            //array create
            return new int[fsf];
        }
        if(arr[idx] == x){
            // idx+1 , fsf + 1 ,  arr[fsf] = idx ,  return
            // fsf++;
            int tmp[] = allIndices(arr,x,idx+1,fsf+1);
            tmp[fsf] = idx;
            return tmp;
        }else{
            return allIndices(arr,x,idx+1,fsf);// idx+1 , directly return
        }
    }
}
