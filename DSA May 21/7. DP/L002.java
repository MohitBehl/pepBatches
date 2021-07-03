import java.util.Scanner;
public class L002 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        // int moves[] = new int[n];
        // for(int i = 0 ; i < n ; i++){
        //     moves[i] = scn.nextInt();
        // }
        // System.out.println(CSMinMovesTab(moves));
        // // int res = CSMinMovesMem(0,moves,new int[n+1]);
        // // System.out.println(res == Integer.MAX_VALUE ? "invalid input" : res);

        int nr = scn.nextInt() , nc = scn.nextInt();
        int cost[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                cost[i][j] = scn.nextInt();
            }
        }
        count = 0;
        int res1 = minCostRec(0, 0, cost);
        System.out.println(res1+" @ "+count);

        count = 0;
        int res2 = minCostMem(0, 0, cost,new int[nr][nc]);
        System.out.println(res2+" @ "+count);
    }
    
    public static int maxGoldTab(int cost[][]){
        int nr = cost.length;
        int nc = cost[0].length;
        
        int mem[][] = new int[nr][nc];
        
        for(int c = nc-1 ; c >= 0 ; c--){
            for(int r = 0 ; r < nr ; r++){
                if(c == nc-1){
                    mem[r][c] = cost[r][c];
                }else{
                    int max = 0;
                    if(r != 0){
                        max = Math.max(max,mem[r-1][c+1]);//d1
                    }
                    
                    max = Math.max(max,mem[r][c+1]);//d2
                    
                    if(r != nr-1){
                        max = Math.max(max,mem[r+1][c+1]);//d3
                    }
                    
                    mem[r][c] = max + cost[r][c];
                }
            }
        }
        
        int oMax = 0;
        for(int r = 0 ;r < nr; r++){
            oMax = Math.max(oMax,mem[r][0]);
        }
        return oMax;
    }

    public static int minCostTab(int cost[][]){
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[nr][nc];
        
        for(int r = nr-1 ; r >= 0 ; r--){
            for(int c = nc-1 ; c >= 0 ; c--){
                if(r == nr-1 && c == nc-1){
                    // dest
                    mem[r][c] = cost[r][c];
                }else if(r == nr-1){
                    // last row , only horizontal
                    mem[r][c] = mem[r][c+1] + cost[r][c];
                }else if(c == nc-1){
                    // last col , only verticle
                    mem[r][c] = mem[r+1][c] + cost[r][c];
                }else{
                    mem[r][c] = Math.min(mem[r][c+1],mem[r+1][c])+cost[r][c];
                }
            }
        }
        
        return mem[0][0];
    }

    static int count;
    public static int minCostMem(int sr,int sc,int cost[][],int mem[][]){
        count++;
        if(sr == cost.length-1 && sc == cost[0].length-1){
            return mem[sr][sc] = cost[sr][sc];
        }
        if(mem[sr][sc] != 0){
            return mem[sr][sc];
        }
        int minCost = Integer.MAX_VALUE;
        
        if(sc+1 <= cost[0].length-1){
            minCost = Math.min(minCost,minCostMem(sr, sc+1, cost,mem));
        }

        if(sr+1 <= cost.length-1){
            minCost = Math.min(minCost,minCostMem(sr+1, sc, cost,mem));
        }

        minCost += cost[sr][sc];

        return mem[sr][sc] = minCost;
    }

    public static int minCostRec(int sr,int sc,int cost[][]){
        count++;
        if(sr == cost.length-1 && sc == cost[0].length-1){
            return cost[sr][sc];
        }

        int minCost = Integer.MAX_VALUE;

        if(sc+1 <= cost[0].length-1){
            minCost = Math.min(minCost,minCostRec(sr, sc+1, cost));
        }

        if(sr+1 <= cost.length-1){
            minCost = Math.min(minCost,minCostRec(sr+1, sc, cost));
        }

        minCost += cost[sr][sc];

        return minCost;
    }
    
    public static int CSMinMovesTab(int moves[]){
        int n = moves.length;
        int mem[] = new int[n+1];
        
        for(int i = n-1 ; i>=0 ; i--){
            int maxJump = moves[i];
            int minSteps = Integer.MAX_VALUE;
            for(int len = 1 ; len <= maxJump ; len++){
                if(i + len <= n){
                    minSteps = Math.min(minSteps,mem[i+len]);
                }
            }
            
            mem[i] = (minSteps == Integer.MAX_VALUE ? Integer.MAX_VALUE : minSteps+1); 
        }
        
        return mem[0];
    }
    public static int CSMinMovesRec(int idx,int moves[]){
        if(idx == moves.length){
            return 0;
        }
        int maxJmp = moves[idx];
        int minSteps = Integer.MAX_VALUE;
        for(int len = 1; len <= maxJmp ; len++){
            if(idx + len <= moves.length){
                minSteps = Math.min(minSteps,CSMinMovesRec(idx+len, moves));
            }
        }

        return minSteps == Integer.MAX_VALUE ? Integer.MAX_VALUE : minSteps+1;
    }
    public static int CSMinMovesMem(int idx,int moves[],int mem[]){
        if(idx == moves.length){
            return 0;
        }
        if(mem[idx] != 0){
            return mem[idx];
        }
        int maxJmp = moves[idx];
        int minSteps = Integer.MAX_VALUE;
        for(int len = 1; len <= maxJmp ; len++){
            if(idx + len <= moves.length){
                minSteps = Math.min(minSteps,CSMinMovesMem(idx+len, moves,mem));
            }
        }

        return mem[idx] = (minSteps == Integer.MAX_VALUE ? Integer.MAX_VALUE : minSteps+1);
    }
}
