import java.io.*;
import java.util.*;
public class L005 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // String str = scn.nextLine();
        // printKPC(str,"");

        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        // printMazePaths(0,0,nr-1,nc-1,"");
        // printMazePaths(0,0,nr-1,nc-1,"");

        String str = scn.nextLine();
        
        printEncodings(str,"");
    }
    static String keypad[] = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKPC(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String roq = str.substring(1);
        String word  = keypad[Integer.parseInt(ch+"")];
        
        for(int i = 0 ; i < word.length() ; i++){
            printKPC(roq,asf+word.charAt(i));
        }
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    // public static void printMazePaths(int sr, int sc, int dr, int dc, String asf) {
    //     if(sr > dr || sc > dc){
    //         return;
    //     }
        
    //     if(sr == dr && sc == dc){
    //         System.out.println(asf);
    //         return;
    //     }
        
    //     printMazePaths(sr,sc+1,dr,dc,asf+"h");
    //     printMazePaths(sr+1,sc,dr,dc,asf+"v");
    // }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        for(int jmp = 1 ; sc + jmp <= dc ; jmp++){
            printMazePaths(sr,sc+jmp,dr,dc,psf+"h"+jmp);
        }
        
        for(int jmp = 1 ; sr + jmp <= dr ; jmp++){
            printMazePaths(sr+jmp,sc,dr,dc,psf+"v"+jmp);
        }
        
        for(int jmp = 1 ; sr + jmp <= dr && sc + jmp <= dc; jmp++){
            printMazePaths(sr+jmp,sc+jmp,dr,dc,psf+"d"+jmp);
        }
    }

    public static void printEncodings(String str,String enc) {
        if(str.length() == 0){
            System.out.println(enc);
            return;
        }
        if(str.charAt(0) == '0'){
            return;
        }
        
        // single digit num
        char firstChar = str.charAt(0);
        int num1 = Integer.parseInt(firstChar+"");
        printEncodings(str.substring(1),enc +(char)('a'+num1-1));
        
        if(str.length() > 1){
            // double digit num
            char secondChar = str.charAt(1);
            int num2 = Integer.parseInt(""+firstChar+secondChar);
            if(num2 >= 10 && num2 <= 26){
                printEncodings(str.substring(2),enc +(char)('a'+num2-1));
            }
        }
    }
}
