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


    public static class MSTPair implements Comparable < MSTPair > {
        int vtx,
        parent,
        wt;

        MSTPair(int vtx, int parent, int wt) {
            this.vtx = vtx;
            this.parent = parent;
            this.wt = wt;
        }

        public int compareTo(MSTPair o) {
            return this.wt - o.wt;
        }

        public String toString() {
            return ("[" + this.vtx + "-" + this.parent + "@" + this.wt + "]");
        }
    }

    public static void PrimsAlgo(ArrayList < Edge > [] graph) {
        int src = 0;

        PriorityQueue < MSTPair > pq = new PriorityQueue < MSTPair > ();
        pq.add(new MSTPair(src, -1, 0));
        boolean visited[] = new boolean[graph.length];

        while (pq.size() > 0) {
            MSTPair priorityPair = pq.remove();

            if (visited[priorityPair.vtx] == false) {
                // mark +  print
                visited[priorityPair.vtx] = true;
                if (priorityPair.parent != -1) {
                    System.out.println(priorityPair);
                }

                // add unvisited nbrs
                for (Edge e: graph[priorityPair.vtx]) {
                    if (visited[e.nbr] == false) {
                        pq.add(new MSTPair(e.nbr, priorityPair.vtx, e.wt));
                    }
                }
            }
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        PrimsAlgo(graph);
    }

}