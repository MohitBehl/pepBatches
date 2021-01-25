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

    public static void HPathAndHCycle(ArrayList < Edge > [] graph, int osrc, int vtx, int count, boolean visited[], String psf) {
        if (count == graph.length - 1) {
            boolean bridge = false;

            for (Edge e: graph[vtx]) {
                if (e.nbr == osrc) {
                    // there exists a direct edge between vtx & osrc
                    bridge = true;
                    break;
                }
            }
            if (bridge == true) {
                // H. Cycle
                System.out.println(psf + "*");
            } else {
                // H. Path
                System.out.println(psf + ".");
            }

            return;
        }

        visited[vtx] = true;

        for (Edge e: graph[vtx]) {
            if (visited[e.nbr] == false) {
                HPathAndHCycle(graph, osrc, e.nbr, count + 1, visited, psf + e.nbr);
            }
        }

        visited[vtx] = false;
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

        int src = Integer.parseInt(br.readLine());

        HPathAndHCycle(graph, src, src, 0, new boolean[graph.length], "" + src);
    }


}