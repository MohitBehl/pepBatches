import java.util.*;
public class rotate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        // logic
        // 0. number of digits
        int tmp = n , count = 0;
        
        while(tmp != 0){
            tmp = tmp/10;
            count++;
        }
        
        // 1. true rotation number
        k = k % count;
        
        // 2. handle -ve rotation
        if(k < 0){
           k = k + count;
        }
        
        // 3. num : p1 + p2 #split
        int div = (int)Math.pow(10,k);
        int p1 = n / div;
        int p2 = n % div;
        
        // 4. ans : p2p1 #merge
        int mul = (int) Math.pow(10,count-k);
        int ans = (p2*mul)+p1;
        
        System.out.println(ans);
       }
}
