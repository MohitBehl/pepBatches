import java.util.*;

public class Main{

public static void main(String[] args) {

    // // declaration
    // String str = "hello";
    // // output
    // System.out.println(str);
    x// // input
    // // Scanner scn = new Scanner(System.in);
    // // // String s1 = scn.next(); // reading/processing a word
    // // // System.out.println(s1);
    // // String s2 = scn.nextLine();
    // // System.out.println(s2); // reading/processing a line 
    
    // // Extra-functionalities
    
    // // 1. length
    // System.out.println("String :"+str+" length : "+str.length());
    
    // // 2. charAt
    // for(int idx = 0 ; idx < str.length() ; idx++){
    //     System.out.println(idx+" --> "+str.charAt(idx));
    // }
    
    // // str.charAt(0) = 'm'; //changes not allowed in string 
    
    // // 3. substring
    
    // System.out.println(str.substring(2));
    // System.out.println(str.substring(2,4));
    
    // 4. split
    Scanner scn = new Scanner(System.in);
    String line = scn.nextLine();
    System.out.println(line);
    String tmp[] = line.split(" ");
    
    for(int i = 0 ; i < tmp.length ;i++){
        System.out.println(i+"-->"+tmp[i]);
    }
     
 }
}