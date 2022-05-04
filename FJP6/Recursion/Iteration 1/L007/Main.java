import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        printEncodings(str, "");
    }

    public static void printEncodings(String qsf,String asf) {
        if(qsf.length() == 0){
            System.out.println(asf);
            return;
        }
        // single digit
        char n1 = qsf.charAt(0);
        if(n1 == '0'){
            return;
        }else{
            char enc1 = (char)('a'+(n1-'1'));
            printEncodings(qsf.substring(1), asf+enc1);
            
            // multiple digit
            if(qsf.length() > 1){
                String tmp = qsf.substring(0,2);
                int n2 = Integer.parseInt(tmp);

                if(n2 <= 26){
                    char enc2 = (char) ('a' + (n2-1));
                    printEncodings(qsf.substring(2), asf+enc2);
                }
            }
        }
    }

}