import java.io.*;
import java.util.*;
public class iterDFS {
    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
     public static class DFSPair{
         int vtx;
         String psf;
         DFSPair(int vtx,String psf){
             this.vtx = vtx;
             this.psf = psf;
         }
     }
     public static void dfsIter(ArrayList<Edge>[] graph,int src){
         Stack<DFSPair> st = new Stack<>();
         
         st.push(new DFSPair(src,src+""));
         boolean visited[] = new boolean[graph.length];
         while(st.size() > 0){
             DFSPair top = st.pop();
             
             if(visited[top.vtx] == false){
                 visited[top.vtx] = true;
                 
                 System.out.println(top.vtx+"@"+top.psf);
                 
                 for(Edge e : graph[top.vtx]){
                     if(visited[e.nbr] == false){
                         st.push(new DFSPair(e.nbr,top.psf+e.nbr));
                     }
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
  
        dfsIter(graph,src);  
     }
}
