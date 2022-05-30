import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        printSubSequence(str,"");
    }

    public static void printSubSequence(String qsf,String asf){
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }

        char ch = qsf.charAt(0);
        String roq = qsf.substring(1);
        printSubSequence(roq,asf+ch);
        printSubSequence(roq,asf);
    }

    public static void printPermutations(String qsf,String asf){
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        StringBuilder sb = new StringBuilder(qsf);
        
        for(int i = 0 ; i < qsf.length() ; i++){
            char ch = qsf.charAt(i);
            sb.deleteCharAt(i);
            String roq = sb.toString();

            printPermutations(roq,asf+ch);

            sb.insert(i,ch);
        }
    }
}
