import java.io.*;
import java.util.*;

public class ToggleCase {

	public static String toggleCase(String str){
		String res = "";
		for(int idx = 0 ; idx < str.length() ; idx++){
		    char ch = str.charAt(idx);
		    
		    if(ch >= 'a' && ch <= 'z'){
		        // lower case letter
		        char uc = (char)('A'+(ch-'a'));
		        res = res + uc;
		    }else if(ch >= 'A' && ch <= 'Z'){
		        // upper case letter
		        char lc = (char)('a'+(ch-'A'));
		        res = res + lc;
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