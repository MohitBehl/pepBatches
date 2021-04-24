import java.util.Scanner;
public class L002 {
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int b = scn.nextInt();
        // int n1 = scn.nextInt();
        // int n2 = scn.nextInt();
    
        // int d = getSum(b, n1, n2);
        // System.out.println(d);

        // // int d = getDifference(b, n1, n2);
        // // System.out.println(d);

        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int idx = 0 ; idx < arr.length ; idx++){
            arr[idx] = scn.nextInt();
        }
        
        // int x = scn.nextInt();
        // int res = find(arr,x);
        
        // System.out.println(res);

        int res = spanOfArray(arr);
        System.out.println(res);
     }
    
     public static int   getSum(int base, int n1, int n2){
         int rv = 0 , pow = 1 , carry = 0;
         
         while(n1 > 0 || n2 > 0 || carry > 0){
             int d1 = n1 % 10;
             int d2 = n2 % 10;
             
             int sum = d1 + d2 + carry;
             int digit = sum % base;
             carry = sum / base;
             
             rv = (digit*pow)+rv;
             
             n1 = n1 / 10;
             n2 = n2 / 10;
             pow = pow * 10;
         }
         
         return rv;
     }

     public static int getDifference(int b, int n1, int n2){
        int rv = 0 , pow = 1 , borrow = 0;
        
        while(n2 > 0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            
            int diff = d2 - d1 - borrow;
            if(diff < 0){
                diff = diff + b;
                borrow = 1;
            }else{
                borrow = 0;
            }
            
            rv = (diff * pow) + rv;
            
            n1 = n1 / 10;
            n2 = n2 / 10;
            pow = pow * 10;
        }
        
        return rv;
    }

    public static void reverse(int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        
        while(lo < hi){
            int tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            
            lo++;
            hi--;
        }
    }

    public static int find(int arr[] , int x){
        for(int idx = 0 ; idx < arr.length ; idx++){
            if(arr[idx] == x){
                return idx;
            }
        }
        
        return -1;
    }

    public static int spanOfArray(int arr[]){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int val : arr){
            if(val > max){
                max = val;
            }
            
            if(val < min){
                min = val;
            }
        }
        
        return max-min;
    }


}
