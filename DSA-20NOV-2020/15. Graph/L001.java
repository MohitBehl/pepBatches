import java.util.ArrayList;
import java.util.Scanner;
public class L001{
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

        int src = scn.nextInt();
        int dest = scn.nextInt();

        // boolean hasPath = hasPath(graph,src,dest,new boolean[graph.length]);
        // System.out.println(hasPath);
        allPath(graph,src,dest,new boolean[graph.length],""+src);
    }

    public static boolean hasPath(ArrayList<Edge> graph[] , int vtx,int dest, boolean visited[]){
        if(vtx == dest){
            return true;
        }
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                boolean res = hasPath(graph,e.nbr,dest,visited);
                if(res){
                    return true;
                }
            }
        }

        return false;
    }
    
    public static void allPath(ArrayList<Edge> graph[] , int vtx ,int dest , boolean visited[] , String psf){
        if(vtx == dest){
            System.out.println(psf);
            return;
        }
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                allPath(graph,e.nbr,dest,visited,psf+e.nbr);
            }
        }
        visited[vtx] = false;
    }
}