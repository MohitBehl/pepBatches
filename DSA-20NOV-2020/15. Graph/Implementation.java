import java.util.ArrayList;
public class Main{
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.wt = wt;
            this.nbr = nbr;
        }

        public String toString(){
            return "["+src+" -> "+nbr+"] @ "+wt;
        }
    }
    public static void display(ArrayList<Edge> graph[]){
        for(int idx = 0 ; idx < graph.length ; idx++){
            System.out.print(idx +" --> ");

            for(Edge e : graph[idx]){
                System.out.print(e+" ,");
            }
            System.out.println(".");
        }
    }
    public static void main(String args[]){
        int vtces = 7;
        ArrayList<Edge> graph[] = new ArrayList[vtces];

        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,3,40));
        graph[0].add(new Edge(0,1,10));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,5));

        graph[4].add(new Edge(4,3,5));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,5,3));
        graph[6].add(new Edge(6,4,8));

        display(graph);
    }
}