import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");

        System.out.println(sb + " length : " + sb.length());

        sb.append("world");

        System.out.println(sb + " length : " + sb.length());

        System.out.println(sb.charAt(2));

        sb.deleteCharAt(0);
        System.out.println(sb);

        sb.insert(0,'h');
        System.out.println(sb);

        sb.setCharAt(0,'#');
        System.out.println(sb);

        System.out.println(sb.reverse());

        System.out.println(sb.substring(5));
    }

}