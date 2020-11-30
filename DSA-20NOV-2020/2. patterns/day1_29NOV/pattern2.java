public class pattern2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        for(int r = 1 ; r <= n ; r++){
            int nst = n + 1 - r; //(no of stars)
            
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            
            System.out.println();
        }

    }
}
