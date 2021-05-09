import java.io.*;
import java.util.*;

public class removePrime {
    
    public static boolean isPrime(int val){
        for(int div = 2 ; div * div <= val ; div++){
            if(val % div == 0){
                return false;
            }
        }
        return true;
    }
	public static void solution(ArrayList<Integer> al){
// 		for(int idx = 0 ; idx < al.size() ; idx++){
// 		    int val = al.get(idx);
// 		    if(isPrime(val)){
// 		        al.remove(idx);
// 		    }
// 		}

        for(int idx =  al.size() - 1 ; idx >= 0 ; idx--){
            int val = al.get(idx);
            if(isPrime(val)){
                al.remove(idx);
            }
        } 
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}