import java.io.*;
import java.util.*;

public class PrintAllPalindromicSubString {
    public static boolean isPalindrome(String s){
        int lo = 0; 
        int hi = s.length()-1;
        
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                return false;
            }
            
            lo++;
            hi--;
        }
        
        return true;
    }
	public static void solution(String str){
		for(int sp = 0 ; sp <= str.length()-1 ; sp++){
		    for(int ep = sp+1 ; ep <= str.length() ; ep++){
		        String ss = str.substring(sp,ep);
		        
		        if(isPalindrome(ss)){
		            System.out.println(ss);
		        }
		    }
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}