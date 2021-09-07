import java.io.*;
import java.util.*;
public class BFSFile {

    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
     static class Pair{
         int vtx;
         String psf;
         Pair(int vtx,String psf){
             this.vtx = vtx;
             this.psf = psf;
         }
     }
     public static void BFS(ArrayList<Edge>[] graph,int src){
         Queue<Pair> queue = new ArrayDeque<>();
         boolean vis[] = new boolean[graph.length];
         queue.add(new Pair(src,""+src));
         
         while(queue.size() > 0){
             Pair rem = queue.remove();
             
             if(vis[rem.vtx]){
                 continue;
             }
             
             vis[rem.vtx] = true;
             System.out.println(rem.vtx+"@"+rem.psf);
             
             for(Edge e : graph[rem.vtx]){
                 if(vis[e.nbr] == false){
                     queue.add(new Pair(e.nbr,rem.psf+e.nbr));
                 }
             }
         }
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           graph[v1].add(new Edge(v1, v2));
           graph[v2].add(new Edge(v2, v1));
        }
  
        int src = Integer.parseInt(br.readLine());
  
        BFS(graph,src);
     } 
}
