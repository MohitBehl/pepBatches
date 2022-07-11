import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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

    //   int src = Integer.parseInt(br.readLine());

    //   BFS(graph,src);
    System.out.println(isGraphCyclic(graph));
   }
   public static class Pair{
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
        Pair rem = queue.remove();// remove

        if(vis[rem.vtx] == false){
            vis[rem.vtx] = true;
            System.out.println(rem.vtx+"@"+rem.psf);
            for(Edge e : graph[rem.vtx]){
                if(vis[e.nbr] == false){
                    queue.add(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
        }
    }
   }

   public static boolean isGraphCyclic(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    for(int vtx = 0 ; vtx < graph.length ; vtx++){
        if(vis[vtx] == false){ // unchecked vtx
            boolean res = isCompCyclic(graph,vtx,vis); 
            if(res) return true;
        }
    }
    return false;
   }
    // isCompCyclic(ArrayList<Edge>[] graph) : returns true if cycle exists otherwise returns false & mark members of component
   public static boolean isCompCyclic(ArrayList<Edge>[] graph,int src,boolean vis[]){
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(src);
    while(queue.size() > 0){
        int vtx = queue.remove();
        if(vis[vtx] == true){ // cycle detected
            return true;
        }else{
            vis[vtx] = true;
            for(Edge e : graph[vtx]){
                if(vis[e.nbr] == false){
                    queue.add(e.nbr);
                }
            }
        }
    }
    return false;
   }
}