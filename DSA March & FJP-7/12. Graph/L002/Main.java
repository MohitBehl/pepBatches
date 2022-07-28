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

    //   int src = Integer.parseInt(br.readLine());
    //   int dest = Integer.parseInt(br.readLine());

    //   printAllPaths(graph,new boolean[graph.length],src,dest,""+src);

      ArrayList<ArrayList<Integer>> comps = getConnectedComp(graph);

      System.out.println(comps);
   }

   public static void printAllPaths(ArrayList<Edge>[] graph,boolean vis[],int vtx,int dest,String psf){
      if(vtx == dest){
         System.out.println(psf);
         return;
      }
      vis[vtx] = true;// visited mark

      for(Edge e : graph[vtx]){
         if(vis[e.nbr] == false){
            printAllPaths(graph,vis,e.nbr,dest,psf+e.nbr);
         }
      }

      vis[vtx] = false;// visited unmark
   }

   public static ArrayList<ArrayList<Integer>> getConnectedComp(ArrayList<Edge>[] graph){
        int nvtces = graph.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[nvtces];
        for(int vtx = 0 ; vtx < nvtces ; vtx++){
            if(vis[vtx] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph,vtx,vis,comp);
                ans.add(comp);
            }
        }
        return ans;
   }

   public static void dfs(ArrayList<Edge>[] graph,int vtx,boolean vis[],ArrayList<Integer> comp){
        vis[vtx] = true;
        comp.add(vtx);

        for(Edge e : graph[vtx]){
            if(vis[e.nbr] == false){
                dfs(graph,e.nbr,vis,comp);
            }
        }
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
         Pair rem = queue.remove(); // remove

         if(vis[rem.vtx]) continue;

         vis[rem.vtx] = true;

         System.out.println(rem.vtx+"@"+rem.psf); // print 

         for(Edge e : graph[rem.vtx]){ // add
            if(vis[e.nbr] == false){
               queue.add(new Pair(e.nbr,rem.psf+e.nbr));
            }
         }
      }
   }

   public static int numberOfIslands(int arr[][]){
      int count = 0;
      for(int r = 0 ; r < arr.length ; r++){
         for(int c = 0 ; c < arr[0].length ; c++){
            if(arr[r][c] == 0){ // univisted land
               floodFill(arr,r,c); // mark all connected land area
               count++;
            }
         }
      }
      return count;
   }
   // 0 : unvisited land area , 1 : water , 2 : visited land area
   public static void floodFill(int arr[][],int r,int c){
      arr[r][c] = 2;
      if(r-1 >= 0 && arr[r-1][c] == 0) floodFill(arr,r-1,c);// top
      if(c-1 >= 0 && arr[r][c-1] == 0) floodFill(arr,r,c-1);// left
      if(r+1 < arr.length && arr[r+1][c] == 0) floodFill(arr,r+1,c);// down 
      if(c+1 < arr[0].length && arr[r][c+1] == 0) floodFill(arr,r,c+1);// right
   }
}