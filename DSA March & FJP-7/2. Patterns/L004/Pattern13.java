import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int inp = scn.nextInt();

        for(int row = 0 ; row < inp ; row++){
            int ncr = 1;
            for(int col = 0 ; col <= row ; col++){
                System.out.print(ncr+"\t");
                int n = row , r = col;
                int next = ((n-r)*ncr)/(r+1);
                ncr = next;
            }
            System.out.println();
        }
    }    
}
