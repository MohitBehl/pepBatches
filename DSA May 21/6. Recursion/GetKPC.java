import java.util.*;

public class GetKPC {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        String str = scn.nextLine();
        ArrayList<String> list = getKPC(str);
        System.out.println(list);
    }
    static String keypad[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String> blist = new ArrayList<>();
            blist.add("");
            return blist;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        ArrayList<String> rres = getKPC(roq);
        
        
        ArrayList<String> myList = new ArrayList<>();
        int key = Integer.parseInt(ch+"");
        String word = keypad[key];
        for(int i = 0 ; i < word.length() ; i++){
            for(String s : rres){
                myList.add(word.charAt(i)+s);
            }
        }
        
        return myList;
    }

}