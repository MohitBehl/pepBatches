import java.util.*;

public class Main {

	public static int solution(String str){
		HashSet<Character> set = new HashSet<>();
		HashMap<Character,Integer> map = new HashMap<>();

		for(int i = 0 ; i < str.length() ; i++){
			set.add(str.charAt(i));
		}

		int i = 0 , j = 0;
		int min = Integer.MAX_VALUE;
		
		while(j <= str.length()){
			boolean flag = true;
			if(map.size() != set.size() && j < str.length()){
				char ch = str.charAt(j);// aquire
				map.put(ch,map.getOrDefault(ch,0)+1);
				flag = false;
				j++;
			}
			if(map.size() == set.size()){
				min = Math.min(min,j-i);
				Integer freq = map.get(str.charAt(i));
				if(freq == 1){
					map.remove(str.charAt(i));
				}else{
					map.put(str.charAt(i),freq-1);
				}
				i++;
				flag = false;
			}
			if(flag){
				break;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
