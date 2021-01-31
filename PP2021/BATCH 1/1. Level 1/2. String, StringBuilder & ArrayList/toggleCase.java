import java.io.*;
import java.util.*;

public class Main {

    public static String toggleCase(String str) {
        StringBuilder res = new StringBuilder();
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);

            if (ch >= 'A' && ch <= 'Z') {
                // ch : upper case -> lower case
                char lc = (char)((ch - 'A') + 'a');
                res.append(lc);
            } else if (ch >= 'a' && ch <= 'z') {
                // ch : lower case -> upper case
                char uc = (char)((ch - 'a') + 'A');
                res.append(uc);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

}