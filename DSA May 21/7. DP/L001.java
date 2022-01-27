import java.util.Scanner;
public class L001 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        
        // int n = scn.nextInt();
        
        // // int res = fib1(n,new int[n+1]);
        // // System.out.println(res);
        // int res = fib2(n);
        // System.out.println(res);

        int n = scn.nextInt();
        
        int moves[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }
        
        int res = ClimbStairsVarJumpRec(0,moves);
        System.out.println(res);
    }
    
    public static int fib1(int n,int mem[]){
        if(n == 1 || n == 0){
            return mem[n] = n;
        }
        
        if(mem[n] != 0){
            return mem[n];    
        }
        
        int fibNm1 = fib1(n-1,mem);
        int fibNm2 = fib1(n-2,mem);
        
        int fibN = fibNm1+fibNm2;
        
        return mem[n] = fibN;
    }
    
    public static int fib2(int n){
        int mem[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 1 || i == 0){
                mem[i] = i;
                continue;
            }
            
            int fibNm1 = mem[i-1];
            int fibNm2 = mem[i-2];
            
            int fibN = fibNm1+fibNm2;
            
            mem[i] = fibN;
        }
        return mem[n];
    }

    public static int climbStairsRec(int n){
        if(n == 0){
            return 1;
        }
        
        int tways = 0;
        
        if(n-1 >= 0){
            tways += climbStairsRec(n-1);
        }
        if(n-2 >= 0){
            tways += climbStairsRec(n-2);
        }
        if(n-3 >= 0){
            tways += climbStairsRec(n-3);
        }
        
        return tways;
    }
    
    public static int climbStairsM(int n,int mem[]){
        if(n == 0){
            return mem[n] = 1;
        }
        
        if(mem[n] != 0){
            return mem[n];    
        }
        
        int tways = 0;
        
        if(n-1 >= 0){
            tways += climbStairsM(n-1,mem);
        }
        if(n-2 >= 0){
            tways += climbStairsM(n-2,mem);
        }
        if(n-3 >= 0){
            tways += climbStairsM(n-3,mem);
        }
        
        return mem[n] = tways;
    }

    public static int climbStairsT(int n){
        int mem[] = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                mem[i] = 1;
                continue;
            }
            
            int tways = 0;
            
            if(i-1 >= 0){
                tways += mem[i-1];
            }
            if(i-2 >= 0){
                tways += mem[i-2];
            }
            if(i-3 >= 0){
                tways += mem[i-3];
            }
            
            mem[i] = tways;
        }
        
        return mem[n];
    }

    public static int ClimbStairsVarJumpRec(int i,int moves[]){
        if(i == moves.length){
            return 1;
        }
        int tways = 0;
        int maxJump = moves[i];
        for(int len = 1 ; len <= maxJump ; len++){
            if(i+len <= moves.length){
                tways += ClimbStairsVarJumpRec(i+len,moves);
            }
        }
        
        return tways;
    }
}
