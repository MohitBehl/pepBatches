import java.util.Scanner;

public class PaintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[][] = new int[n][3];

        for(int idx = 0 ; idx < n ; idx++){
            arr[idx][0] = scn.nextInt();
            arr[idx][1] = scn.nextInt();
            arr[idx][2] = scn.nextInt();
        }

        System.out.println(solution(arr));

    }

    public static int solution(int arr[][]){
        int red = arr[0][0], blue = arr[0][1], green = arr[0][2];

        for(int idx = 1 ; idx < arr.length ; idx++){
            int nRed = arr[idx][0] + Math.min(blue,green);
            int nBlue = arr[idx][1] + Math.min(red,green);
            int nGreen = arr[idx][2] + Math.min(red,blue);

            red = nRed;
            blue = nBlue;
            green = nGreen;
        }

        return Math.min(red,Math.min(blue,green));
    }
}
