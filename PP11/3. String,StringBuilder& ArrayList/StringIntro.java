import java.util.Scanner;

public class StringIntro {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // String word = scn.next();
        // String line = scn.nextLine();

        // System.out.println("word : " + word);
        // System.out.println("Line : "+line);
        // int num = scn.nextInt();
        // String str = scn.nextLine();

        // System.out.println(num);
        // System.out.println(str);

        // String s1 = "hello";
        // String s2 = "world";
        // String s3 = s1 + " " + s2;
        // System.out.println(s3);

        // System.out.println(1+2+"hello");
        // System.out.println("hello"+1+2);
        // System.out.println(1+"hello"+2);
        // // char -> unicode
        // char ch = 'K';
        // int code = ch;
        // System.out.println(code);
        // // unicode -> char
        // int code = 109;
        // char ch = (char)code;
        // System.out.println(ch);

        String s = "";

        for(int i = 1 ; i <= 1000 ; i++){
            s = s + "1";
        }

        System.out.println(s);
    }
}
