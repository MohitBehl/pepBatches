import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // int sum = 0;
        // for(int i = 1 ; i <= n ; i = i + 1){
        //     sum = sum + i;
        // }
        int sum = (n * (n+1)) / 2;
        System.out.println(sum);

    }
}