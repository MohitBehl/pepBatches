import java.util.*;

public class Main{
    public static boolean isPalindrome(String str){
        int lo = 0 , hi = str.length()-1;
        
        while(lo < hi){
            if(str.charAt(lo) != str.charAt(hi)){
                return false;
            }
            
            lo++;
            hi--;
        }
        
        return true;
    }
	public static void solution(String str){
		// get all substrings
		
		for(int sidx = 0 ; sidx <= str.length()-1 ; sidx++){
		    for(int eidx = sidx+1 ; eidx <= str.length() ; eidx++){
		        String ss = str.substring(sidx,eidx);
		        if(isPalindrome(ss)){
    		        System.out.println(ss);
		        }
		    }
		}
		
    }
    
    public static String compression1(String str){
		String res = str.charAt(0)+"";
		
		for(int idx = 1 ; idx < str.length() ; idx++){
		    char curr = str.charAt(idx);
		    char prev = str.charAt(idx-1);
		    
		    if(curr == prev){
		        // skip
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
		        count++;
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


    // String s1 = "hello";
    // System.out.println(s1);
    
    // String s2 = new String("hello");
    // System.out.println(s2);
    
    // String s3 = "hello";
    
    // System.out.println(s1.equals(s2));
    
    // System.out.println(s2.equals(s3));
    
    // System.out.println(s1.equals(s3));
    
    // // String p1 = "hello";
    // // String p2 = " world";
    // // String p3 =  p1 + p2;
    
    // // System.out.println("p1 : "+p1);
    // // System.out.println("p2 : "+p2);
    // // System.out.println("p3 : "+p3);
    
    // // System.out.println(p3.length());
    
    // // String s1 = "abcde";
    // // for(int idx = 0 ; idx < s1.length() ; idx++){
    // //     System.out.println(s1.charAt(idx));
    // // }
    
    // String str = "hello world !!!";
    // // System.out.println(str.substring(9));
    // // System.out.println(str.substring(8));
    // // System.out.println(str.substring(14));
    // // System.out.println(str.substring(15));
    // // System.out.println(str.substring(16));
    // System.out.println(str.substring(0,5));
    // System.out.println(str.substring(4,7));
    // System.out.println(str.substring(6,9));
    // System.out.println(str.substring(7,7));
    // // System.out.println(str.substring(8,7));
    
    String s = "";
    
    for(int i = 1 ; i <= 300000 ; i++){
        s += 1;
    }
    
    System.out.println(s);
 }
}