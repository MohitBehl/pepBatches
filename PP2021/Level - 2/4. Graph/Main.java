import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src= src;
            this.wt = wt;
            this.nbr = nbr;
        }
        public String toString(){
            return ("src : "+this.src+" nbr : "+this.nbr+" wt : "+this.wt);
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int nvtces = scn.nextInt();
        
        ArrayList<Edge>[] graph = new ArrayList[nvtces+1];
        for(int i = 0 ; i <= nvtces ; i++){
            graph[i] = new ArrayList<>();
        }

        // input
        for(int  r = 1; r <= nvtces ; r++){
            for(int c = 1; c <= nvtces ; c++){
                int vl = scn.nextInt();
                if(vl > 0){
                    graph[r].add(new Edge(r,c,vl));
                }
            }
        }

        for(int i = 1; i <= nvtces ; i++){
            System.out.println(i+" --> " +graph[i]);
        }
    }

    /*
    4
    0 10 0 4
    10 0 2 0
    0 2 0 3
    4 0 3 0
    */
}
