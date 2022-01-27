import java.util.*;
public class countFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int f = getDigitFrequency(n, k);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int k) {
        int count = 0;
        while(n != 0){
            int rem = n % 10;
            if(rem == k){
                count++;
            }
            
            n = n / 10;
        }
        return count;
    }
}
