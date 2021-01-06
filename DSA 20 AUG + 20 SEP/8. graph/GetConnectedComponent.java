import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class GetConnectedComponent {
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
    public static ArrayList<ArrayList<Integer>> GCC(ArrayList < Edge > [] graph){
        boolean visited[] = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> allComps = new ArrayList<ArrayList<Integer>>();

        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                GCCHelper(graph,vtx,visited,comp);
                allComps.add(comp);
            }
        }
        return allComps;
    }
    public static void GCCHelper(ArrayList < Edge > [] graph,int vtx,boolean[] visited,ArrayList<Integer> comp){
        comp.add(vtx);
        visited[vtx] = true;

        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                GCCHelper(graph,e.nbr,visited,comp); 
            }
        }
    }

    public static boolean isGraphConnected(ArrayList < Edge > [] graph){
        return GCC(graph).size() == 1;
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

        // ArrayList < ArrayList < Integer >> comps = GCC(graph);
        // System.out.println(comps);

        System.out.println(isGraphConnected(graph));
    }

}
