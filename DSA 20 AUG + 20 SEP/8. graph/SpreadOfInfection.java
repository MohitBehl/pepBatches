import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class SpreadOfInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int vtces = scn.nextInt();
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = scn.nextInt();
        int t = scn.nextInt();

        System.out.println(spreadOfInfection(graph, t, src));
    }

    public static class Pair{
        int vtx;
        int toi;

        Pair(int vtx,int toi){
            this.vtx = vtx;
            this.toi = toi;
        }
    }
    public static int spreadOfInfection(ArrayList<Edge>[] graph,int responseTime,int src){
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(new Pair(src,1));
        int count = 0;

        while(queue.size() > 0){
            Pair fpair = queue.remove();// remove

            if(fpair.toi <= responseTime){
                
                if(visited[fpair.vtx] == false){
                    visited[fpair.vtx] = true;
                    count++;

                    for(Edge e : graph[fpair.vtx]){
                        if(visited[e.nbr] == false){
                            queue.add(new Pair(e.nbr,fpair.toi+1));
                        }
                    }
                }
            }
        }
        return count;
    }
}
