import java.util.ArrayList;
import java.util.Scanner;

public class Implementation {
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void display(ArrayList<Edge> graph[]){
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            System.out.print(vtx+" -> ");
            
            for(Edge e : graph[vtx]){
                System.out.print(e.src+"-"+e.nbr+"@"+e.wt+" ,");
            }

            System.out.println(".");
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[] ,int vtx,int dest,boolean visited[]){
        if(vtx == dest){
            return true;
        }

        visited[vtx] = true; //  visited marked
        
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                //unvisited edge
                if(hasPath(graph, e.nbr, dest,visited)){
                    // path found
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest){
        boolean visited[] = new boolean[graph.length];
        return hasPath(graph,src,dest,visited);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[vtces];
        int arr[] = new int[6];
        for(int vtx = 0 ; vtx < vtces ; vtx++){
            graph[vtx] = new ArrayList<Edge>();
        }

        for(int edge = 0 ; edge < edges ; edge++){
            int v1 = scn.nextInt() , v2 = scn.nextInt() , wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt)); // src : v1 , nbr : v2 , wt : wt
            graph[v2].add(new Edge(v2,v1,wt)); // src : v2 , nbr : v1 , wt : wt
        }


        // display(graph);

        int src = scn.nextInt();
        int dest = scn.nextInt();
        System.out.println(hasPath(graph, src, dest));

    }
}

// 7
// 8
// 0 1 10
// 0 3  40
// 1 2 10
// 2 3 10
// 3 4 5
// 4 5 3
// 4 6 6
// 5 6 3
