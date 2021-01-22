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
    
    public static void topologicalSort(ArrayList < Edge > [] graph){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> ans = new Stack<>();
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                topologicalSort(graph,vtx,ans,visited);
            }
        }
        
        while(ans.size() > 0){
            System.out.println(ans.pop());
        }
    }
    
    public static void topologicalSort(ArrayList < Edge > [] graph,int src,Stack<Integer> st ,boolean[] visited){
        visited[src] = true;
        
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                topologicalSort(graph,e.nbr,st,visited);
            }
        }
        
        st.push(src);
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
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here
        topologicalSort(graph);
    }

}