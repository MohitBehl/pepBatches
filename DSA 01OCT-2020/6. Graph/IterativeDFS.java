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
    public static class IDFSPair {
        int vtx;
        String psf;

        IDFSPair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void IterDFS(ArrayList < Edge > [] graph, int src) {
        Stack < IDFSPair > st = new Stack < > ();
        st.push(new IDFSPair(src, "" + src));
        boolean visited[] = new boolean[graph.length];
        while (st.size() > 0) {
            IDFSPair tpair = st.pop(); // pop/remove

            if (visited[tpair.vtx] == false) {
                // processing : mark + print
                visited[tpair.vtx] = true;
                System.out.println(tpair.vtx + "@" + tpair.psf);

                // unvisited nbrs push 
                for (Edge e: graph[tpair.vtx]) {
                    if (visited[e.nbr] == false) {
                        st.push(new IDFSPair(e.nbr, tpair.psf + e.nbr));
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        IterDFS(graph, src);
    }
}