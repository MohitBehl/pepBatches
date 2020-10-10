import java.io.*;
import java.util.*;

public class Main {

    public static boolean palindrome(String str){
        int lo = 0;
        int hi = str.length()-1;
        
        while(lo < hi){
            char ch1 = str.charAt(lo);
            char ch2 = str.charAt(hi);
            
            if(ch1 != ch2){
                return false;
            }
            
            lo++;
            hi--;
        }
        
        return true;
    }
	public static void solution(String str){
		//write your code here
		
		for(int i = 0 ; i < str.length() ; i++){
		    for(int j = i + 1; j <= str.length() ; j++){
		        String ss = str.substring(i,j);
		        if(palindrome(ss)){
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