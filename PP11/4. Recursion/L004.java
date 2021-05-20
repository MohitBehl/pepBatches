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

}