import java.util.ArrayList;
import java.util.Scanner;

public class PerfectFriends {
    public static void display(ArrayList<Edge>[] graph){
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            System.out.print(vtx+" -> ");
            for(Edge e : graph[vtx]){
                System.out.print(e.nbr+" ");
            }
            System.out.println();
        }
    }
    public static class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static ArrayList<ArrayList<Integer>> GCC(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> allComp = new ArrayList<ArrayList<Integer>>();
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                GCCHelper(graph, vtx, visited, comp);
                allComp.add(comp);
            }
        }
        return allComp;
    }
    public static void GCCHelper(ArrayList<Edge>[] graph,int vtx,boolean[] visited,ArrayList<Integer> comp){
        comp.add(vtx);
        visited[vtx] = true;

        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                GCCHelper(graph, e.nbr, visited, comp);
            }
        }
    }

    public static int countNumberOfPerfectPairs(ArrayList<Edge>[] graph){
        ArrayList<ArrayList<Integer>> comp = GCC(graph);

        int count = 0;
        for(int i = 0 ; i <= comp.size() - 2 ; i++){
            for(int j = i + 1 ; j < comp.size() ; j++){
                count += (comp.get(i).size() * comp.get(j).size());
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt(); // number of friends
        int k = scn.nextInt(); // number of edges / number of friendships
        
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0 ; i < k ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1,v2));// v1-->src , v2-->nbr
            graph[v2].add(new Edge(v2,v1));// v2-->src , v1-->nbr
        }

        // display(graph);
        // System.out.println(GCC(graph));
        System.out.println(countNumberOfPerfectPairs(graph));
    }
}
