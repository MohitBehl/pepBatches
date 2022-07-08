import java.io.*;
import java.util.*;

public class Main {
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

   static class Pair implements Comparable<Pair> {
      int wsf;
      String psf;

      Pair(int wsf, String psf){
         this.wsf = wsf;
         this.psf = psf;
      }

      public int compareTo(Pair o){
         return this.wsf - o.wsf;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      int criteria = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      boolean[] visited = new boolean[vtces];
      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
      
      System.out.println("Smallest Path = " + spath + "@" + spathwt);
      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
   }



   static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String lpath;
   static Integer lpathwt = Integer.MIN_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static String fpath;
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>();
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      if(src == dest){
         // System.out.println(psf+"@"+wsf);

         if(wsf > lpathwt){   // largest
            lpathwt = wsf;
            lpath = psf;
         }
         if(wsf < spathwt){   // smallest
            spathwt = wsf;
            spath = psf;
         }

         if(pq.size() < k){   // kth largest
            pq.add(new Pair(wsf,psf));
         }else if(pq.peek().wsf < wsf){
            pq.remove(); // remove weak
            pq.add(new Pair(wsf,psf));
         }

         // ceil -> just larger -> min among larger values
         if(wsf > criteria){ // larger
            if(wsf < cpathwt){ // min among larger
               cpathwt = wsf;
               cpath = psf;
            }
         }
         // floor -> just smaller -> max amongh smaller values
         if(wsf < criteria){ // smaller
            if(wsf > fpathwt){ // max among smaller
               fpathwt = wsf;
               fpath = psf;
            }
         }
         return;
      }

      visited[src] = true;
      for(Edge e : graph[src]){
         if(visited[e.nbr] == false){
            multisolver(graph,e.nbr,dest,visited,criteria,k,psf+e.nbr,wsf+e.wt);
         }
      }
      visited[src] = false;
   }

   public static ArrayList<ArrayList<Integer>> getAllComponents(ArrayList<Edge>[] graph){
    boolean vis[] = new boolean[graph.length];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for(int i = 0 ; i < vis.length ; i++){
        if(vis[i] == false){
            ArrayList<Integer> comp = new ArrayList<>();
            getComp(graph,vis,i,comp);
            ans.add(comp);
        }
    }
    return ans;
   }

    public static void getComp(ArrayList<Edge>[] graph,boolean []vis,int src,ArrayList<Integer> comp){
        vis[src] = true;
        comp.add(src);

        for(Edge e : graph[src]){
            if(vis[e.nbr] == false){
                getComp(graph,vis,e.nbr,comp);
            }
        }
    }
}