public class pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int row = 1 , nst = 1 , f = 0 , s = 1;
        
        while(row <= n){
            // print stars
            for(int i = 1; i<= nst; i++){
                System.out.print(f+"\t");
                
                int third = f + s;
                f = s;
                s = third;
            }
            
            // move to new line 
            System.out.println();
            
            // preparation
            nst++;
            row++;
        }

    }
}
