public class L001 {
    public static void main(String[] args) {
        int n = 80;
        Long startTime = System.currentTimeMillis();
        // System.out.println(fibR(n));
        // System.out.println(fibM(n,new int[n+1]));
        System.out.println(fibT(n));
        Long endTime = System.currentTimeMillis();

        System.out.println("Duration : "+(endTime-startTime));
    }

    public static int fibR(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        int fibNm1 = fibR(n-1);
        int fibNm2 = fibR(n-2);
        int fibN = fibNm1 + fibNm2;

        return fibN;
    }

    public static int fibM(int n,int qb[]){
        if(n == 1){
            return qb[1] = 0;
        }
        if(n == 2){
            return qb[2] = 1;
        }

        if(qb[n] != 0){
            return qb[n];
        }

        int fibNm1 = fibM(n-1,qb);
        int fibNm2 = fibM(n-2,qb);
        int fibN = fibNm1 + fibNm2;

        return qb[n] = fibN;
    }

    public static int fibT(int n){
        int qb[] = new int[n+1];

        for(int i = 1; i <= n ; i++){
            if(i == 1){
                qb[i] = 0;
            }else if(i == 2){
                qb[i] = 1;
            }else{
                qb[i] = qb[i-1] + qb[i-2];
            }
        }

        return qb[n];
    }

    public static int countStairPaths(int n){
        int qb[] = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                qb[0] = 1;
            }else if(i == 1){
                qb[i] = qb[i-1];
            }else if(i == 2){
                qb[i] = qb[i-1] + qb[i-2];
            }else{
                qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
            }
        }
        
        return qb[n];
    }

    public static int countPathVariableJump(int moves[]){
        int n = moves.length;
        int qb[] = new int[n+1];
        
        for(int i = n ; i >= 0 ; i--){
            if(i == n){
                qb[n] = 1; // base case
            }else{
                int maxJmp = moves[i];
                if(maxJmp == 0){
                    qb[i] = 0;
                }else{
                    for(int jmp = 1 ; jmp <= maxJmp && jmp+i <= n ; jmp++){
                        qb[i] += qb[i+jmp];
                    }
                }
            }
        }
        
        return qb[0];
    }

    
}
