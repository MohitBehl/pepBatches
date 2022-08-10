import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt() , nc = scn.nextInt();

        int cost[][] = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                cost[i][j] = scn.nextInt();
            }
        }

        System.out.println(minCost_tab(cost));
    }
    public static int minCost_tab(int cost[][]){
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[nr][nc];

        for(int r = 0 ; r < nr ; r++){
            for(int c = 0 ; c < nc ; c++){
                if(r == 0 && c == 0){
                    mem[r][c] = cost[r][c];
                }else if(r == 0){
                    mem[r][c] = cost[r][c] + mem[r][c-1];
                }else if(c == 0){
                    mem[r][c] = cost[r][c] + mem[r-1][c];
                }else{
                    int min = Math.min(mem[r][c-1],mem[r-1][c]);
                    mem[r][c] = min + cost[r][c];
                }
            }
        }

        return mem[nr-1][nc-1];
    }
}