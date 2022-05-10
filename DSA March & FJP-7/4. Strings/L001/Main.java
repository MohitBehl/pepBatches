import java.util.*;

public class Main {
    public static boolean isPalindromic(String str){
        int left = 0 , right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
	public static void printAllPalindromicSubString(String str){
        for(int sidx = 0 ; sidx < str.length() ; sidx++){
            for(int eidx = sidx+1 ; eidx <= str.length() ; eidx++){
                String ss = str.substring(sidx, eidx);
                if(isPalindromic(ss))
                    System.out.println(ss);
            }
        }
	}


    public static String compression1(String str){
        String ans = ""+str.charAt(0);
        int idx = 1;

        while(idx < str.length()){
            char curr = str.charAt(idx);
            char prev = str.charAt(idx-1);

            if(curr == prev){
                // do nothing
            }else{
                ans = ans + curr;
            }
            idx++;
        }
		return ans;
	}

	public static String compression2(String str){
        String ans = ""+str.charAt(0);
        int idx = 1;
        int count = 1;
        while(idx < str.length()){
            char curr = str.charAt(idx);
            char prev = str.charAt(idx-1);

            if(curr == prev){
                count++;
            }else{
                if(count > 1){
                    ans = ans + count;
                }
                ans = ans + curr;
                count = 1;
            }
            idx++;
        }
        if(count > 1){
            ans = ans + count;
        }
		return ans;
	}   

    public static String toggleCase(String str){
        String ans = "";

        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            // 'a' - LC = 'A' - UC
            if(ch >= 'a' && ch <= 'z'){
                char uc =(char)('A' + (ch -'a'));
                ans = ans + uc;
            }else if(ch >= 'A' && ch <= 'Z'){
                char lc =(char)('a' + (ch -'A'));
                ans = ans + lc;
            }
        }

        return ans;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		// printAllPalindromicSubString(str);
        // System.out.println(compression1(str));
        // System.out.println(compression2(str));
        System.out.println(toggleCase(str));
	}

}