import java.util.*;
public class Intro{
    public static class Edge{
        int src , dest , wt;

        Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public String toString(){
            return src+" -> "+dest+" @ "+wt;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[7];

        for(int idx = 0 ; idx < graph.length ; idx++){
            graph[idx] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,10));

        graph[4].add(new Edge(4,3,10));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,6,3));
        graph[5].add(new Edge(5,4,3));

        graph[6].add(new Edge(6,5,3));
        graph[6].add(new Edge(6,4,8));

        for(int idx = 0 ; idx < graph.length ; idx++){
            System.out.println(idx +"-->"+graph[idx]);
        }       
    }
}