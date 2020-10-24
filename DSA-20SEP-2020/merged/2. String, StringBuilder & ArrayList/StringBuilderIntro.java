import java.util.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("hello");
        
        // length
        System.out.println(sb.length());

        // charAt
        for (int idx = 0; idx < sb.length(); idx++) {
            System.out.println(idx+"-->"+sb.charAt(idx));
        }
        
        // output
        System.out.println(sb);

        // append
        sb.append('a');
        System.out.println(sb+" "+sb.length());
        
        sb.insert(2,'z');
        System.out.println(sb+" "+sb.length());
        
        sb.delete(3,4);
        System.out.println(sb  +" "+sb.length());
        
        sb.deleteCharAt(0);
        System.out.println(sb+" "+sb.length());
        
        sb.setCharAt(0,'i');
        System.out.println(sb+" "+sb.length());
        
        System.out.println(sb.reverse());
        
        sb.append("pep");
        System.out.println(sb);
    }
}