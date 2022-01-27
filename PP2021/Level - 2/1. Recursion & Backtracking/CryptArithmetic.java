import java.io.*;
import java.util.*;

public class CryptArithmetic {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();

    HashMap<Character, Integer> charIntMap = new HashMap<>();
    String unique = "";
    for (int i = 0; i < s1.length(); i++) {
      if (!charIntMap.containsKey(s1.charAt(i))) {
        charIntMap.put(s1.charAt(i), -1);
        unique += s1.charAt(i);
      }
    }

    for (int i = 0; i < s2.length(); i++) {
      if (!charIntMap.containsKey(s2.charAt(i))) {
        charIntMap.put(s2.charAt(i), -1);
        unique += s2.charAt(i);
      }
    }

    for (int i = 0; i < s3.length(); i++) {
      if (!charIntMap.containsKey(s3.charAt(i))) {
        charIntMap.put(s3.charAt(i), -1);
        unique += s3.charAt(i);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
  }
    

  public static int makeNum(String s,HashMap<Character,Integer> map){
      StringBuilder sb = new StringBuilder();
      
      for(int idx = 0 ; idx < s.length() ; idx++){
          char ch = s.charAt(idx);
          sb.append(map.get(ch));
      }
      
      return Integer.parseInt(sb.toString());
  }  
  public static void solution(String unique, int idx, 
							  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
							  String s1, String s2, String s3) {
	    if(idx == unique.length()){
	        int n1 = makeNum(s1,charIntMap);
	        int n2 = makeNum(s2,charIntMap);
	        int n3 = makeNum(s3,charIntMap);
	        
	        if(n1+n2 == n3){
	            // print
	            for(int i = 0 ; i < 26 ; i++){
	                char ch = (char)('a'+i);
	                Integer res = charIntMap.get(ch);
	                if(res != null){
	                    System.out.print(ch+"-"+res+" ");
	                }
	            }
	           System.out.println();
	        }
	        return;
	    }
	    char ch = unique.charAt(idx);
	    for(int digit = 0 ; digit <= 9 ; digit++){
	        if(usedNumbers[digit] == false){
	            usedNumbers[digit] = true;
	            charIntMap.put(ch,digit);
	            solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
	            usedNumbers[digit] = false;
	            charIntMap.put(ch,-1);
	        }
	    }
  }

}
