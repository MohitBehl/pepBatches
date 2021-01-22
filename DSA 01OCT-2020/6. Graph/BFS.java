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
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx,String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge>graph[],int src){
        Queue<BFSPair> queue = new ArrayDeque<>();
        queue.add(new BFSPair(src,""+src));
        boolean visited[] = new boolean[graph.length];
        
        while(queue.size() > 0){
            BFSPair fpair = queue.remove();// remove
            
            if(visited[fpair.vtx] == false){
                visited[fpair.vtx] = true;
                System.out.println(fpair.vtx+"@"+fpair.psf);// print
                
                // add
                for(Edge e : graph[fpair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new BFSPair(e.nbr,fpair.psf+e.nbr));
                    }
                }
            }
        }
    }


    public static boolean isCyclic(ArrayList < Edge > [] graph){
        boolean visited[] = new boolean[graph.length];

        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                // bfs + isCyclic(comp)
                if(isCyclic(graph,vtx,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclic(ArrayList < Edge > [] graph,int src,boolean visited[]){
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(src);

        while(queue.size() > 0){
            Integer fVtx = queue.remove();

            if(visited[fVtx] == true){
                // comp is cyclic
                return true;
            }else{
                visited[fVtx] = true;

                for(Edge e : graph[fVtx]){
                    if(visited[e.nbr] == false){
                        queue.add(e.nbr);
                    }
                }
            }
        }

        return false; //  comp has no cycle
    }

    public static class isBipartitePair{
        int vtx,level;
        
        isBipartitePair(int vtx,int level){
            this.vtx = vtx;
            this.level = level;
        }
    } 
    
    public static boolean isBipartite(ArrayList < Edge > [] graph){
        int visited[] = new int[graph.length];
        for(int vtx  = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == 0){
                if(isBipartite(graph,vtx,visited) == false){
                    // graph : not bipartite
                    return false;
                }
            }
        }
        // every comp is bipartite in itself
        return true;
    }

    public static boolean isBipartite(ArrayList < Edge > [] graph,int src,int []visited){
        Queue<isBipartitePair> queue = new ArrayDeque<>();
        queue.add(new isBipartitePair(src,1));
        
        while(queue.size() > 0){
            isBipartitePair fPair = queue.remove();
            
            if(visited[fPair.vtx] == 0){
                // unvisited
                visited[fPair.vtx] = fPair.level;
                
                for(Edge e : graph[fPair.vtx]){
                    if(visited[e.nbr] == 0){
                        queue.add(new isBipartitePair(e.nbr,fPair.level+1));                
                    }
                }
            }else{
                // visited : fPair.level : curr level & visited[fPair.vtx] : level at which vtx was found prev. 
                if(fPair.level%2 != visited[fPair.vtx]%2){
                    // comp : not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static class SOIPair {
        int vtx;
        int toi;

        SOIPair(int vtx, int toi) {
            this.vtx = vtx;
            this.toi = toi;
        }
    }

    public static int SpreadOfInfection(ArrayList < Edge > [] graph, int src, int time) {
        Queue < SOIPair > queue = new ArrayDeque < > ();
        boolean[] visited = new boolean[graph.length];
        int count = 0;
        queue.add(new SOIPair(src, 1));

        while (queue.size() > 0) {
            SOIPair fpair = queue.remove();

            if (visited[fpair.vtx] == false) {
                visited[fpair.vtx] = true;

                if (fpair.toi <= time) {
                    count++;
                }
                if (fpair.toi < time) {
                    for (Edge e: graph[fpair.vtx]) {
                        if (visited[e.nbr] == false) {
                            queue.add(new SOIPair(e.nbr, fpair.toi + 1));
                        }
                    }
                }
            }
        }
        return count;
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

        // BFS(graph,src);
        System.out.println(isCyclic(graph));
    }
}
