import java.util.*;

public class GetStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> list = getStairPaths(n);
        System.out.println(list);
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if(n < 0){
            return new ArrayList<String>();
        }
        ArrayList<String> oneLenPath = getStairPaths(n-1);
        ArrayList<String> twoLenPath = getStairPaths(n-2);
        ArrayList<String> threeLenPath = getStairPaths(n-3);
        
        ArrayList<String> myList = new ArrayList<>();
        for(String path : oneLenPath){
            myList.add(1+path);
        }
        for(String path : twoLenPath){
            myList.add(2+path);
        }
        for(String path : threeLenPath){
            myList.add(3+path);
        }
        
        return myList;
    }

}