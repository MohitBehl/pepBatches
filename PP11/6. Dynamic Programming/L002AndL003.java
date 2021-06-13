public class L002AndL003 {
    public static void ZeroOneKnapSack(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int vls[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            vls[i] = scn.nextInt();
        }
        
        int wts[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        // logic
        
        int dp[][] = new int[n+1][cap+1];
        
        for(int i = 1 ; i <= n ; i++){
            int wt = wts[i-1];
            int vl = vls[i-1];
            for(int j = 1 ; j <= cap ; j++){
                dp[i][j] = dp[i-1][j]; // exc
                if(j >= wt){
                    // inc
                    dp[i][j] = Math.max(dp[i-1][j-wt] + vl,dp[i][j]); 
                }
            }
        }
        
        System.out.println(dp[n][cap]);
    }
    public static class Item implements Comparable<Item>{
        int vl,wt;
        Double vwr;
        
        // this - o : ins
        // o - this : dec
        public int compareTo(Item o){
            if(o.vwr < this.vwr){
                return -1;
            }else if(o.vwr == this.vwr){
                return 0;
            }else{
                return 1;
            }
        }
    }
    public static void fractionalKnapSack(){
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int vls[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            vls[i] = scn.nextInt();
            
        int wts[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            wts[i] = scn.nextInt();
            
        int cap = scn.nextInt();
        
        // logic
        
        Item items[] = new Item[n];
        
        for(int i = 0 ; i < n ; i++){
            items[i] = new Item();
            items[i].vl = vls[i];
            items[i].wt = wts[i];
            items[i].vwr = (vls[i]*1.0) / wts[i];
        }
        
        Arrays.sort(items);
        
        int idx = 0 ;
        double tval = 0.0;
        while(idx < n && cap != 0){
            if(items[idx].wt <= cap){
                cap -= items[idx].wt;
                tval += items[idx].vl;
                idx++;
            }else{
                tval += cap * items[idx].vwr;
                cap = 0;
            }
        }
        System.out.println(tval);
    }
    public static void CountBinaryString(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int oSEW0 = 1 , oSEW1 = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int nSEW0 = oSEW1;
            int nSEW1 = oSEW0 + oSEW1;
            
            oSEW0 = nSEW0;
            oSEW1 = nSEW1;
        }
        
        System.out.println(oSEW0 + oSEW1);
    }
    public static void CountABCSequence(){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int a = 0;
        int ab = 0;
        int abc = 0;
        
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == 'a'){
                a = 2*a + 1;
            }else if(ch == 'b'){
                ab = 2 * ab + a;
            }else if(ch == 'c'){
                abc = 2*abc + ab; 
            }
        }
        
        System.out.println(abc);
    }
    public static void MaximumSumNonAdjacenElement(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        
        // logic
        
        
        int oExc = 0,oInc =0;
        
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                oInc = arr[0];
            }else{
                int nInc = arr[i]+oExc;
                int nExc = Math.max(oExc,oInc);
                
                oInc = nInc;
                oExc = nExc;
            }
        }
        
        System.out.println(Math.max(oExc,oInc));
    }

    public static void PaintHouse() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][3];
    
        for (int i = 0 ; i < n ; i++) {
          arr[i][0] = scn.nextInt();
          arr[i][1] = scn.nextInt();
          arr[i][2] = scn.nextInt();
        }
    
        // logic
    
        int oCostRed = arr[0][0], oCostBlue = arr[0][1], oCostGreen = arr[0][2];
        
        for(int h = 1 ; h < n ; h++){
            int nCostRed = arr[h][0] + Math.min(oCostBlue,oCostGreen);
            int nCostBlue = arr[h][1] + Math.min(oCostRed,oCostGreen);
            int nCostGreen = arr[h][2] + Math.min(oCostRed,oCostBlue);
            
            oCostRed = nCostRed;
            oCostBlue = nCostBlue;
            oCostGreen = nCostGreen;
        }
        
        int minCost = Math.min(oCostRed,Math.min(oCostBlue,oCostGreen));
        System.out.println(minCost);
      }
      public static void TilingWith2x1(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int f = 1 , s = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int t = f + (s);
            
            f = s;
            s = t;
        }
        
        System.out.println(s);
    }
    public static void TilingWithMx1(){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int dp[] = new int[n+1];
        
        for(int len = 0 ; len <= n ; len++){
            if(len < m){
                dp[len] = 1;
            }else if(len == m){
                dp[len] = 2;
            }else{
                dp[len] = dp[len-1] + dp[len-m];
            }
        }
        
        System.out.println(dp[n]);
    }
    public static void FriendsPairing(String[] args){
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // logic
        int f = 1 , s = 1;
        
        for(int i = 2 ; i <= n ; i++){
            int t = (i-1)*f + (s);
            
            f = s;
            s = t;
        }
        
        System.out.println(s);
    }
}
