import java.io.*;
import java.util.*;

public class StringCompression {
	public static String compression1(String str){
		String res = str.charAt(0)+"";
        for(int idx = 1 ; idx < str.length() ; idx++){
            char curr = str.charAt(idx);
            char prev = str.charAt(idx-1);
            
            if(curr == prev){
                // do nothing
            }else{
                res = res + curr;
            }
        }
		return res;
	}
	public static String compression2(String str){
		String res = str.charAt(0)+"";
		int count = 1;

        for(int idx = 1 ; idx < str.length() ; idx++){
            char curr = str.charAt(idx);
            char prev = str.charAt(idx-1);
            
            if(curr == prev){
                count = count+1;
            }else{
                if(count > 1){
                    res = res + count;
                    count = 1;
                }
                res = res + curr;
            }
        }
        if(count > 1){
            res = res + count;
        }
		return res;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}