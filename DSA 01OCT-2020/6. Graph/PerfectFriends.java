import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int src, nbr, wt;
        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static ArrayList < ArrayList < Integer >> GCC(ArrayList < Edge > graph[]) {
        boolean[] visited = new boolean[graph.length];
        ArrayList < ArrayList < Integer >> allComp = new ArrayList < > ();

        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
                ArrayList < Integer > comp = new ArrayList < > ();
                GCCHelper(graph, vtx, visited, comp);
                allComp.add(comp);
            }
        }

        return allComp;
    }
    public static void GCCHelper(ArrayList < Edge > graph[], int vtx, boolean visited[], ArrayList < Integer > comp) {
        visited[vtx] = true;
        comp.add(vtx);

        for (Edge e: graph[vtx]) {
            if (visited[e.nbr] == false) {
                // unvisited nbr
                GCCHelper(graph, e.nbr, visited, comp);
            }
        }
    }

    public static int perfectFriends(ArrayList < Edge > graph[]) {
        ArrayList < ArrayList < Integer >> allComps = GCC(graph);
        int res = 0;
        for (int i = 0; i < allComps.size() - 1; i++) {
            for (int j = i + 1; j < allComps.size(); j++) {
                res += allComps.get(i).size() * allComps.get(j).size();
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();
        ArrayList < Edge > graph[] = new ArrayList[vtces];
        for (int vtx = 0; vtx < vtces; vtx++) {
            graph[vtx] = new ArrayList < Edge > ();
        }

        for (int edge = 0; edge < edges; edge++) {
            int v1 = scn.nextInt(), v2 = scn.nextInt(), wt = 0;

            graph[v1].add(new Edge(v1, v2, wt)); // src : v1 , nbr : v2 , wt : wt
            graph[v2].add(new Edge(v2, v1, wt)); // src : v2 , nbr : v1 , wt : wt
        }
        
        System.out.println(perfectFriends(graph));
    }

}