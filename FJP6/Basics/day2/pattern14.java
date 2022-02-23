import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        for(int i = 1 ; i <= 10 ; i = i + 1){
            int ans = n * i;
            System.out.println(n+" * "+i+" = "+ans);
        }

    }
}