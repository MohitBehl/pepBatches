import java.util.*;
import java.lang.*;

class Prims
{

    public static class Edge{
        int src,nbr,wt;

        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int vtx,wt;
        Pair(int vtx,int wt){
            this.vtx = vtx;
            this.wt  = wt;
        }

        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }
    public static long solve(ArrayList<Edge>[] graph){
        int nvtces = graph.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1,0));
        boolean[] vis = new boolean[nvtces];
        long ans = 0;

        while(pq.size() > 0){
            Pair rem = pq.remove();
            if(vis[rem.vtx] == true){
                continue;
            }

            vis[rem.vtx] = true;
            ans += rem.wt;

            for(Edge e : graph[rem.vtx]){
                if(vis[e.nbr] == false){
                    pq.add(new Pair(e.nbr,e.wt));
                }
            }
        }
        return ans;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
        int nvtces = scn.nextInt() , nedges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[nvtces+1];

        for(int i = 0 ; i <= nvtces ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < nedges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        System.out.println(solve(graph));
	}

}
