import java.io.*;
import java.util.*;

public class Main {
    public static boolean isPalindrome(String str){
        int li = 0 ; // first index
        int ri = str.length()-1; // last index
        
        while(li < ri){
            char c1 = str.charAt(li);
            char c2 = str.charAt(ri);
            
            if(c1 != c2){
                // not palindrome
                return false;
            }            
            li++;
            ri--;
        }   
        // implication :  string is palindrome
        return true;
    }
	public static void solution(String str){
		for(int sp = 0 ; sp < str.length() ; sp++){                  
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