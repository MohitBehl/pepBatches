import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;
public class L002{
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.wt = wt;
            this.nbr = nbr;
        }

    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[vtces];
        for(int idx = 0 ; idx < vtces ; idx++){
            graph[idx] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt() , v2 = scn.nextInt() , wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        // ArrayList<ArrayList<Integer>> gcc = getAllConnectedComponents(graph);
        // System.out.println(gcc);
        // boolean resIsGraphConnected = isGraphConnected(graph);
        // System.out.println(resIsGraphConnected);
        // int src = scn.nextInt();
        // BFS(graph,src);

        // System.out.println(isCyclic(graph));
        System.out.println(isGraphBipartite(graph));
    }
    public static class IsBipartitePair{
        int vtx;
        int level;
        IsBipartitePair(int vtx , int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
    public static boolean isGraphBipartite(ArrayList<Edge> graph[]){
        int visited[] = new int[graph.length];
        Arrays.fill(visited,-1);
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == -1){
                if(isCompBipartite(graph,vtx,visited) == false){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean isCompBipartite(ArrayList<Edge> graph[],int src,int visited[]){
        Queue<IsBipartitePair> queue = new ArrayDeque<>();
        queue.add(new IsBipartitePair(src,src));
        
        while(queue.size() > 0){
            IsBipartitePair pair = queue.remove();

            if(visited[pair.vtx] == -1){
                visited[pair.vtx] = pair.level;

                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == -1){
                        queue.add(new IsBipartitePair(e.nbr,pair.level+1));
                    }
                }
            }else{
                if(pair.level % 2 != visited[pair.vtx] % 2){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                if(isCyclic(graph,vtx,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isCyclic(ArrayList<Edge> graph[],int vtx,boolean visited[]){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vtx);

        while(queue.size() > 0){
            int fVtx = queue.remove();

            if(visited[fVtx] == true){
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
        return false;
    }
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx,String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge> graph[],int src){
        boolean visited[] = new boolean[graph.length];
        Queue<BFSPair> queue = new ArrayDeque<>();
        queue.add(new BFSPair(src,src+""));

        while(queue.size() > 0){
            BFSPair pair = queue.remove();// remove
            if(visited[pair.vtx] == false){
                visited[pair.vtx] = true;
                System.out.println(pair.vtx+"@"+pair.psf);// print 
                
                // add
                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new BFSPair(e.nbr,pair.psf+e.nbr));
                    }
                }
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> getAllConnectedComponents(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                ArrayList<Integer> res = new ArrayList<>();
                getConnectedComp(graph,vtx,visited,res);
                ans.add(res);
            }
        }
        return ans;
    }

    private static void getConnectedComp(ArrayList<Edge> graph[],int vtx,boolean visited[],ArrayList<Integer> res){
        visited[vtx] = true;
        res.add(vtx);

        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                getConnectedComp(graph,e.nbr,visited,res);
            }
        }
    }

    public static boolean isGraphConnected(ArrayList<Edge> graph[]){
        ArrayList<ArrayList<Integer>> gcc = getAllConnectedComponents(graph);
        return gcc.size() == 1;
    }
}