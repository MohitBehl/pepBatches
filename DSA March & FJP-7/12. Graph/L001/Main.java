import java.util.*;

public class Main{
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];

        // initialization
        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new ArrayList<>();
        }

        int nedges = scn.nextInt();

        for(int i = 0 ; i < nedges ; i++){
            int v1 = scn.nextInt() , v2 = scn.nextInt() , wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }


        // for(ArrayList<Edge> edges : graph){
        //     for(Edge edge : edges){
        //         System.out.println(edge.src+"->"+edge.nbr+"@"+edge.wt);
        //     }
        // }

        int src = scn.nextInt() , dest = scn.nextInt();

        System.out.println(hasPath(graph,src,dest,new boolean[vtces]));
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int vtx,int dest,boolean []vis){
        if(vtx == dest) return true;

        vis[vtx] = true;

        for(Edge e : graph[vtx]){
            if(vis[e.nbr] == false){
                // unvisited + nbr
                boolean rres = hasPath(graph,e.nbr,dest,vis);
                if(rres) return true;
            }
        }

        return false;
    }
}

/*
7
8
0 3 3
0 1 10
1 2 1
2 3 2
3 4 4
4 5 5
5 6 6
4 6 6
*/