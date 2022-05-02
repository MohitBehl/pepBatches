import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // String ques = scn.nextLine();
        // printSS(ques,"");

        // int nr = scn.nextInt();
        // int nc = scn.nextInt();
        // printMazePaths(0, 0, nr-1, nc-1, "");

        String ques = scn.nextLine();
        printPermutations(ques, "");
    }

    public static void printSS(String qsf, String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = qsf.charAt(0);
        String roq = qsf.substring(1);
        printSS(roq, asf+ch);// inc
        printSS(roq, asf);// exc
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        // invalid
        if(sr > dr || sc > dc){
            return;
        }
        // valid
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        printMazePaths(sr,sc+1,dr,dc,psf+"h"); //  h
        printMazePaths(sr+1,sc,dr,dc,psf+"v"); //  v
    }

    public static void printPermutations(String qsf, String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        for(int i = 0 ; i < qsf.length() ; i++){
            char ch = qsf.charAt(i);
            StringBuilder sb = new StringBuilder(qsf);
            sb.deleteCharAt(i);
            String roq = sb.toString();
            printPermutations(roq, asf+ch);
        }
    }
}