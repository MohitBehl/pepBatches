public class pattern11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1, nst = 1;
        int k = 1;
        while(row <= n){
            // code for each row
            // print stars
            for(int i = 1; i <= nst ; i++){
                System.out.print(k+"\t");
                k++;
            }
            
            // move to new line 
            System.out.println();
            
            // preparation
            nst++;
            row++;
        }

    }
}
