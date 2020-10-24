import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
        
        StringBuilder res = new StringBuilder();
        for(int idx = 0 ; idx < str.length() ; idx++){
            char ch = str.charAt(idx);

            if(ch >= 'a' && ch <= 'z'){
                // lowercase --> uppercase
                char uc = 'A'+(ch-'a');
                res.append(uc);
            }else if(ch >= 'A' &&  ch <= 'Z'){
                // uppercase --> lowercase
                char lc = 'a' + (ch-'A');
                res.append(lc);
            }
        }
		return res;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

}