import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        public String toString(){
            return "src : "+src+" nbr : "+nbr+" wt : "+wt;
        }
    }

    public static void display(ArrayList<Edge>[] graph){
        for(int i = 0 ; i < graph.length ; i++){
            System.out.print(i+" --> ");
            System.out.println(graph[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces]; 
        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new ArrayList<>();
        }

        int n = scn.nextInt();
        for(int i = 0 ; i < n ; i++){
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            graph[u].add(new Edge(u,v,wt));
            graph[v].add(new Edge(v,u,wt));
        }

        display(graph);
    }
}
