public class pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1 , nsp = n-1 , nst = 1;
        
        while(row <= n){
            
            // work to be done in each row 
            // print spaces
            for(int i = 1 ; i <= nsp ; i++){
                System.out.print("\t");
            }
            
            // print stars
            for(int i = 1 ; i <= nst ; i++){
                System.out.print("*\t");
            }
            
            // newline
            System.out.println();
            
            // preparation for next row
            nsp--;
            nst++;
            row++;
        }

    }
}
