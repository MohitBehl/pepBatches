import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // input

        // 1st part
        // for(int i = 1 ; i <= n ; i++){
        //     System.out.print("*\t");
        // }

        // // 2nd part
        // for(int r = 1 ; r <= n ; r++){
        //     for(int c = 1 ; c <= n ; c++){
        //         System.out.print("*\t");
        //     }

        //     // line change
        //     System.out.println();
        // }

        // 3rd,4th,5th part
        for(int r = 1 ; r <= n ; r++){
            for(int c = 1 ; c <= n ; c++){
                if(c == 1 || c == n){
                    System.out.print("*\t"); // first col or last col
                }else  if(r > n/2 && (r == c || r + c == n+1)){
                    System.out.print("*\t"); // second half && ldiag or rdiag
                }else{
                    System.out.print("\t");
                }
            }
            // line change
            System.out.println();
        }
    }
}
