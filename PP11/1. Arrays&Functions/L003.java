public class L003 {
    public static void rotate(int[] a, int k){
        int n = a.length;
        k = k % n; // true rotation number 
        
        if(k < 0){
            // -ve rotation -> +ve rotation number
            k = k + n;
        }
        
        // arr = p1 + p2
        
        reverse(a,n-k,n-1);// reverse part2
        reverse(a,0,n-k-1);// reverse part1
        reverse(a,0,n-1);// reverse a
      }
      
      // reverse(a,lo,hi) : reverse part of array from [lo->hi]
      public static void reverse(int a[],int lo,int hi){
          while(lo < hi){
              int tmp = a[lo];
              a[lo] = a[hi];
              a[hi] = tmp;
              
              lo++;
              hi--;
          }
      }

      public static int[] inverse(int[] a){
        int res[] = new int[a.length];
        
        for(int idx = 0 ; idx < a.length ; idx++){
            int val = a[idx];
            res[val] = idx;
        }
        
        return res;
      }
}
