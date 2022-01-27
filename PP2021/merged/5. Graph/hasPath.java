import java.io.*;
import java.util.*;

public class hasPath {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt){
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   public static void main(String[] args) throws Exception {
      Scanner scn = new Scanner(System.in);

      int vtces = scn.nextInt();
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for(int i = 0; i < vtces; i++){
         graph[i] = new ArrayList<>();
      }

      int edges = scn.nextInt();
      for(int i = 0; i < edges; i++){
        //  String[] parts = br.readLine().split(" ");
         int v1 = scn.nextInt();
         int v2 = scn.nextInt();
         int wt = scn.nextInt();
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = scn.nextInt();
      int dest = scn.nextInt();

      boolean res = hasPath(graph,src,dest,new boolean[vtces]);
      
      System.out.println(res);
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int vtx,int dest,boolean visited[]){
        // logic
        if(vtx == dest){
            return true;
        }
        
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                boolean rres = hasPath(graph,e.nbr,dest,visited);
                if(rres){
                    return true;
                }
            }
        }
        
        return false;
    }
}   