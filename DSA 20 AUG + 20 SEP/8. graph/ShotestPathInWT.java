import java.io.*;
import java.util.*;

public class ShotestPathInWT {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static class SPPair implements Comparable<SPPair>{
        int vtx , wsf;
        String psf;
        SPPair(int vtx,String psf,int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
        }
        
        public int compareTo(SPPair o){
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        
        
        PriorityQueue<SPPair> pq = new PriorityQueue<SPPair>();
        boolean[] visited = new boolean[graph.length];
        
        pq.add(new SPPair(src,""+src,0));
        
        while(pq.size() > 0){
            // remove
            SPPair minPair = pq.remove();
            
            if(visited[minPair.vtx] == false){
                visited[minPair.vtx] = true;
                
                System.out.println(minPair.vtx+" via "+minPair.psf+" @ "+minPair.wsf);
                
                for(Edge e : graph[minPair.vtx]){
                    if(visited[e.nbr] == false){
                        pq.add(new SPPair(e.nbr,minPair.psf+e.nbr,minPair.wsf+e.wt));
                    }
                }
            }    
        }
    }
}
