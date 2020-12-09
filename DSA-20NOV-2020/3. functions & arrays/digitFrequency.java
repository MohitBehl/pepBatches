import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int k) {
        int count = 0;
        
        while(n != 0){
            int rms = n % 10;
            if(rms == k){
                count++;
            }
            
            n = n / 10;
        }
        
        return count;
    }
}