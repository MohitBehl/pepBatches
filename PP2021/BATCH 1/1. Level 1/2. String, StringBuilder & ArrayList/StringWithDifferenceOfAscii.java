import java.io.*;
import java.util.*;

public class Main {

    public static String solution(String str) {

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int idx = 1; idx < str.length(); idx++) {
            char curr = str.charAt(idx);
            char prev = str.charAt(idx - 1);

            sb.append(curr - prev);
            sb.append(curr);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}