import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
        StringBuilder inp = new StringBuilder(str);
        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < inp.length() ;i++){
            char ch = inp.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                // char --> lowerCase
                char capCh = 'A' + (ch - 'a');
                res.append(capCh);
            }else if(ch >= 'A' && ch <= 'Z'){
                // ch --> upperCase
                char lowCh = 'a' + (ch - 'A');
                res.append(lowCh);
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