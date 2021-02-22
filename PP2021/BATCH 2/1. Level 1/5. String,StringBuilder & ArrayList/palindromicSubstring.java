import java.util.Scanner;

public class palindromicSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String inp = scn.nextLine();

        palindromeSubstring(inp);
    }

    public static void palindromeSubstring(String str){
        for(int i = 0 ; i < str.length() ; i++){
            for(int j = i+1 ; j <= str.length() ; j++){
                String ss = str.substring(i,j);

                if(isPalindrome(ss)){
                    System.out.println(ss);
                }
            }
        }
    }

    public static boolean isPalindrome(String str){
        int lo = 0;
        int hi = str.length() - 1;

        while(lo < hi){
            if(str.charAt(lo) != str.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }

        return true;
    }
}
