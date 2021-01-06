import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.io.*;


public class BFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx , String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFSTraversal(ArrayList<Edge>[] graph,int src){
        Queue<BFSPair> queue = new ArrayDeque<BFSPair>();
        queue.add(new BFSPair(src,""+src));
        boolean[] visited = new boolean[graph.length];
        while(queue.size() > 0){
            // remove
            BFSPair fPair = queue.remove();
            if(visited[fPair.vtx] == false){
                visited[fPair.vtx] = true;
                // print
                System.out.println(fPair.vtx+"@"+fPair.psf);

                // add : unvisited nbrs
                for(Edge e : graph[fPair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new BFSPair(e.nbr,fPair.psf+e.nbr));
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

        // write your code here  
        BFSTraversal(graph, src)    ;
    }
}
