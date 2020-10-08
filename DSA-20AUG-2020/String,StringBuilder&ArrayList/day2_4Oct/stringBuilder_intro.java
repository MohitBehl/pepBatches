import java.util.*;

public class Main{

public static void main(String[] args) {
    
    StringBuilder sb = new StringBuilder("hello");
    
    System.out.println(sb);
    
    sb.append('d');
    System.out.println(sb);
    
    System.out.println(sb.length());
    
    sb.insert(1,'z');
    System.out.println(sb);
    
    sb.deleteCharAt(1);
    System.out.println(sb);
    
    sb.setCharAt(0,'f');
    System.out.println(sb);
    
    char ch = sb.charAt(4);
    System.out.println(ch);

 }
}