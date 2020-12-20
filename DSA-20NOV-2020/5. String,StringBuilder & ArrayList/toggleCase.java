import java.io.*;
import java.util.*;

public class Main {

	public static String toggleCase(String str){
		
		StringBuilder res = new StringBuilder();
		
		for(int idx = 0 ; idx < str.length() ; idx++){
		    char ch = str.charAt(idx);
		    
		    if(ch >= 'a' && ch <= 'z'){
		        // ch --> small letters
		        char cap = (char)('A' + (ch-'a'));
		        res.append(cap);
		    }else if(ch >= 'A' && ch <= 'Z'){
		        // ch ---> capital letters
		        char small = (char)('a' + (ch - 'A'));
		        res.append(small);
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