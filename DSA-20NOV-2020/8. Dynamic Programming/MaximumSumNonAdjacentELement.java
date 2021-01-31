import java.util.Scanner;
public class MaximumSumNonAdjacentElements{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(solution(arr));
    }

    public static int solution(int arr[]){
        int inc = arr[0], exc = 0;
        for(int idx = 1 ; idx < arr.length ; idx++){
            int ninc = arr[idx] + exc;
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }

        return Math.max(inc,exc);
    }
}