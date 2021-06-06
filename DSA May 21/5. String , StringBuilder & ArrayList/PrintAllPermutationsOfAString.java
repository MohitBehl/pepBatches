import java.io.*;
import java.util.*;

public class PrintAllPermutationsOfAString {
    public static int fact(int n){
        int ans = 1;
        for(int i = 1; i <= n ; i++){
            ans = ans * i;
        }
        
        return ans;
    }
	public static void solution(String str){
		int count = fact(str.length());
		
		for(int num = 0 ; num < count ; num++){
		    StringBuilder sb = new StringBuilder(str);
		    int len = str.length();
		    int tNum = num;
		    
		    while(len > 0){
		        int rem = tNum % len;
		        tNum = tNum / len;
		        
		        System.out.print(sb.charAt(rem));
		        sb.deleteCharAt(rem);
		        len--;
		    }
		    System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}