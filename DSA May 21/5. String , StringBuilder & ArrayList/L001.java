public class L001 {
    public static void main(String[] args) {
        // StringIntro();        
        // printAllPalindromicSubstring("abcc");
        // charIntro();
        System.out.println(toggleCase("pepCODing"));
    }
    
    public static String compression1(String str){
		String res = "";
        // logic
        for(int idx = 0 ; idx < str.length() ; idx++){
            if(idx == 0){
                res = res + str.charAt(0);
            }else{
                char curr = str.charAt(idx);
                char prev = str.charAt(idx-1);
                
                if(curr != prev){
                    res = res + curr;
                }
            }
        }
		return res;
	}

    public static String compression2(String str){
		String res = "";
		int count = 0;
		// logic
		for(int idx = 0 ; idx < str.length() ; idx++){
		    if(idx == 0){
		        res = res + str.charAt(idx);
		        count = 1;
		    }else{
		        char curr = str.charAt(idx);
                char prev = str.charAt(idx-1);
                
                if(curr != prev){
                    if(count > 1){
                        res = res + count;
                        count = 1;
                    }
                    res = res + curr;
                }else{
                    count++;
                }
		    }
		}
		if(count > 1){
		    res = res + count;
		}
		return res;
	}

    public static boolean isPalindrome(String s){
        int lo = 0 , hi = s.length()-1;
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                return false; //  non-palindromic string 
            }
            lo++;
            hi--;
        }

        return true; //  palindromic string
    }
    
    public static void printAllPalindromicSubstring(String str){
        for(int si = 0 ; si < str.length() ; si++){
            for(int ei = si+1 ; ei <= str.length() ; ei++){
                String ss = str.substring(si,ei);
                if(isPalindrome(ss)){
                    System.out.println(ss);
                }
            }
        }
    }

    public static void StringIntro(){
        String s1 = "hello";
        String s2 = new String("World");

        // concatenation
        String s3 = s1 +" "+ s2;

        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println("s3 : " + s3);

        // Golden Rule
        System.out.println(1+9+"Hello");
        System.out.println(1+"Hello"+9);
        System.out.println("Hello"+1+9);

        // Special Features
        //1. Length
        System.out.println("Len of S3 : " + s3.length());
        //2. charAt
        System.out.println("1th char of "+s1+" :"+s1.charAt(1));
        //3. visiting all characters in a String
        for(int idx = 0 ; idx < s1.length() ; idx++){
            System.out.println(idx+"th char of "+s1+" :"+s1.charAt(idx));
        }
        //4. substring
    }

    public static void charIntro(){
        for(int i = 0 ; i <= 9 ; i++){
            int enc = i+'0';
            System.out.println(i+" --> "+enc);
        }

        char ch = 'M';
        int enc = ch;
        System.out.println(ch+" --> "+enc);
    }

    public static String toggleCase(String str){
        String res = "";

        for(int idx = 0 ; idx < str.length() ; idx++){
            char ch = str.charAt(idx);

            if(ch >= 'A' && ch <= 'Z'){
                // upper case -> lower case 
                char lcl = (char)('a'+(ch-'A'));
                res = res + lcl;
            }else if(ch >= 'a' && ch <= 'z'){
                // lower case -> upper case
                char ucl = (char)('A' + (ch - 'a'));
                res = res + ucl;
            }
        }

        return res;        
    }

}
