import java.io.*;
import java.util.*;

public class CompilationOFOrder {
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

        topologicalSort(graph);
    }

    public static void topologicalSort(ArrayList < Edge > [] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                topologicalSort(graph,vtx,visited,st);
            }
        }

        while(st.size() > 0){
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph,int vtx,boolean[] visited,Stack<Integer> st){
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                topologicalSort(graph,e.nbr,visited,st);
            }
        }
        st.push(vtx);
    }
}
