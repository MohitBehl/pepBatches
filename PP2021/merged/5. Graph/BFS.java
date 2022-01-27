import java.io.*;
import java.util.*;

public class BFS {
  static class Edge {
    int src;
    int nbr;
    int wt;
    Edge(int src, int nbr,int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }
  public static class Pair{
      int vtx;
      String psf;

      Pair(int vtx , String psf){
          this.vtx = vtx;
          this.psf = psf;
      }
  }
  public static void bfs(ArrayList<Edge>[] graph,int src){
      Queue<Pair> queue = new ArrayDeque<>();

      queue.add(new Pair(src,""+src));
      boolean visited[] = new boolean[graph.length];
      while(queue.size() > 0){
        Pair fpair = queue.remove();

        if(visited[fpair.vtx] == false){
            visited[fpair.vtx] = true;
            System.out.println(fpair.vtx+"@"+fpair.psf);

            for(Edge e : graph[fpair.vtx]){
                if(visited[e.nbr] == false){
                    queue.add(new Pair(e.nbr,fpair.psf+e.nbr));
                }
            }
        }
      }
  }
  public static boolean isGraphCyclic(ArrayList<Edge>[] graph){
    boolean visited[] = new boolean [graph.length];
    for(int v = 0 ; v < graph.length ; v++){
        if(visited[v] == false){
            boolean res = isCompCyclic(graph, v,visited);
            if(res == true){
                return true;
            }
        }
    }
    return false;
  }
  public static boolean isCompCyclic(ArrayList<Edge>[] graph,int src,boolean visited[]){
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(src);
    while(queue.size() > 0){
      int fvtx = queue.remove();
      if(visited[fvtx] == false){
          visited[fvtx] = true;          
          for(Edge e : graph[fvtx]){
              if(visited[e.nbr] == false){
                  queue.add(e.nbr);
              }
          }
      }else{
          // vtx is already visited --> more than one path exists , return true
          return true;
      }
    }
    return false;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph){
    boolean visited[]=  new boolean[graph.length];
    for(int v = 0 ; v < graph.length ; v++){
        if(visited[v] == false){
            boolean res = isCompBipartite(graph,v,visited);
            if(res == false){
                return false;
            }
        }
    }
    
    return true;
}
public static class BPair{
  int vtx,level;
  BPair(int vtx,int level){
      this.vtx = vtx;
      this.level = level;
  }
}
public static boolean isCompBipartite(ArrayList<Edge>[] graph,int src,boolean visited[]){
  Queue<BPair> queue= new ArrayDeque<>();
  queue.add(new BPair(src,0));
  HashMap<Integer,Integer> hm = new HashMap<>();
  while(queue.size() > 0){
      BPair pair = queue.remove();
      
      if(visited[pair.vtx] == true){
          if(pair.level%2 != hm.get(pair.vtx)%2){
              return false;
          }
      }else{
          hm.put(pair.vtx,pair.level);
          visited[pair.vtx] = true;
          
          for(Edge e : graph[pair.vtx]){
              if(visited[e.nbr] == false){
                  queue.add(new BPair(e.nbr,pair.level+1));
              }
          }
      }
  }
  return true;
}
  


  public static class SPIWPair implements Comparable<SPIWPair>{
      int vtx,wsf;
      String psf;

      SPIWPair(int vtx,int wsf,String psf){
        this.wsf =wsf;
        this.psf = psf;
        this.vtx = vtx;
      }
      public int compareTo(SPIWPair o){
          return this.wsf - o.wsf;
      }
  }
  public static void shortestPathInWt(ArrayList<Edge>[] graph,int src){
    PriorityQueue<SPIWPair> pq = new PriorityQueue<>();
    pq.add(new SPIWPair(src,0,""+src));
    boolean visited[] = new boolean[graph.length];
    while(pq.size() > 0){
        SPIWPair pair = pq.remove();

        if(visited[pair.vtx] == false){
            visited[pair.vtx] = true;

            System.out.println(pair.vtx+" via "+pair.psf+" @ "+pair.wsf);

            for(Edge e : graph[pair.vtx]){
                if(visited[e.nbr] == false){
                    pq.add(new SPIWPair(e.nbr,pair.wsf+e.wt,pair.psf+e.nbr));
                }
            }
        }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      graph[v1].add(new Edge(v1, v2,0));
      graph[v2].add(new Edge(v2, v1,0));
    }

    int src = Integer.parseInt(br.readLine());

    bfs(graph,src);
  }
}