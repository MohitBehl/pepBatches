import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class L003{
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

        // Hamiltonian(graph,new boolean[graph.length] , src , 0 , ""+src);
        // ShortestPathInTermsOfWT(graph,src);
        MinimumWire(graph);
    }
    public static void Hamiltonian(ArrayList<Edge> graph[] , boolean []visited , int vtx , int count , String psf,int osrc){
        if(count == graph.length-1){
            boolean haveDirectEdge = false;
            for(Edge e : graph[vtx]){
                if(e.nbr == osrc){
                    haveDirectEdge = true;
                    break;
                }
            }
            
            if(haveDirectEdge){
                // hamiltonian cycle
                System.out.println(psf+"*");
            }else{
                // hamiltonian path
                System.out.println(psf+".");
            }
        }   
        
        visited[vtx] = true;
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                Hamiltonian(graph,visited,e.nbr,count+1,psf+e.nbr,osrc);
            }
        }
        visited[vtx] = false;
    }

    public static class SPSolver implements Comparable<SPSolver>{
        int vtx;
        int wsf;
        String psf;

        SPSolver(int vtx,int wsf,String psf){
            this.vtx = vtx;
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(SPSolver o){
            return this.wsf - o.wsf;
        }
    }

    public static void ShortestPathInTermsOfWT(ArrayList<Edge> graph[] , int src){
        PriorityQueue<SPSolver> pq = new PriorityQueue<>();

        pq.add(new SPSolver(src,0,""+src));

        boolean visited[] = new boolean[graph.length];

        while(pq.size() > 0){
            SPSolver tmp = pq.remove();

            if(visited[tmp.vtx] == false){
                visited[tmp.vtx] = true;

                System.out.println(tmp.vtx+"via"+tmp.psf+"@"+tmp.wsf);

                for(Edge e : graph[tmp.vtx]){
                    if(visited[e.nbr] == false){
                        pq.add(new SPSolver(e.nbr,tmp.wsf+e.wt,tmp.psf+e.nbr));
                    }
                }
            }
        }
    }
    public static class MinWSolver implements Comparable<MinWSolver>{
        int vtx;
        int pvtx;
        int wt;

        MinWSolver(int vtx , int pvtx , int wt){
            this.vtx = vtx;
            this.pvtx = pvtx;
            this.wt = wt;
        }
        public int compareTo(MinWSolver o){
            return this.wt - o.wt;
        }
    }
    public static void MinimumWire(ArrayList<Edge> graph[]){
        PriorityQueue<MinWSolver> pq = new PriorityQueue<>();

        pq.add(new MinWSolver(src,-1,0));

        boolean visited[] = new boolean[graph.length];

        while(pq.size() > 0){
            MinWSolver tmp = pq.remove();

            if(visited[tmp.vtx] == false){
                visited[tmp.vtx] = true;

                if(tmp.pvtx != -1){
                    System.out.println("["+tmp.vtx+"-"+tmp.pvtx+"@"+tmp.wt+"]");
                }

                for(Edge e : graph[tmp.vtx]){
                    if(visited[e.nbr] == false){
                        pq.add(new MinWSolver(e.nbr,tmp.vtx,e.wt));
                    }
                }
            }
        }
    }
}