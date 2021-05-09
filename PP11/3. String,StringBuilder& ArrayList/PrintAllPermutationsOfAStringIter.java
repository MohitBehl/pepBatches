import java.io.*;
import java.util.*;

public class PrintAllPermutationsOfAStringIter {
    public static int fact(int num){
        int res = 1;
        for(int i = 1; i <= num ; i++){
            res = res * i;
        }
        
        return res;
    }
	public static void solution(String str){
	    int n = str.length();
		int totalPerm = fact(n);
		
		for(int num = 0 ; num < totalPerm ; num++){
		    int tmp = n;
		    String mStr = str;
		    String perm = "";
		    int val = num;
		    while(tmp != 0){
		        int rem = val % tmp;
		        val = val/tmp;
		        perm = perm + mStr.charAt(rem);
		        
		        String lp = mStr.substring(0,rem);
		        String rp = mStr.substring(rem+1);
		        mStr = lp+rp;
		        tmp--;
		    }
		    System.out.println(perm);
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}