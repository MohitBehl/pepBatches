import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.management.Query;

public class Graph {
    public static class Edge{
        int src,nbr,wt;
        Edge(int src,int nbr,int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void display(ArrayList<Edge>[] graph){
        int vtces = graph.length;
        for(int i = 0 ; i < vtces ; i++){
            ArrayList<Edge> list = graph[i];
            System.out.print(i+" -> ");
            for(Edge e : list){
                System.out.print(e.nbr+" ");
            }
            System.out.println();
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest){
        boolean[] visited = new boolean[graph.length];
        return hasPathHelper(graph,src,visited,dest);
    }
    
    public static boolean hasPathHelper(ArrayList<Edge>[] graph,int vtx,boolean[] visited,int dest){
        if(vtx == dest){
            return true;
        }
        
        visited[vtx] = true;
        
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                boolean res = hasPathHelper(graph,e.nbr,visited,dest);
                
                if(res){
                    return true;
                }
            }
        }
        
        return false;
    }


    public static class DFSPair{
        int vtx;
        String psf;
        DFSPair(int vtx , String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
     public static void dfsIter(ArrayList<Edge>[] graph,int src){
         Stack<DFSPair> st = new Stack<>();
         st.push(new DFSPair(src,src+""));
         boolean visited[] = new boolean[graph.length];
         
         while(st.size() > 0){
             DFSPair tpair = st.pop();
             
             if(visited[tpair.vtx] == false){
                 visited[tpair.vtx] = true;
                 
                 System.out.println(tpair.vtx +"@"+ tpair.psf);
                 
                 for(Edge e : graph[tpair.vtx]){
                     if(visited[e.nbr] == false){
                         st.push(new DFSPair(e.nbr,tpair.psf+e.nbr));
                     }
                 }
             }
         }
         
     }

    public static void allPath(ArrayList<Edge>[] graph,int src,int dest){
        boolean[] visited = new boolean[graph.length];
        allPathHelper(graph,src,visited,dest,""+src);
    }
    
    public static void allPathHelper(ArrayList<Edge>[] graph,int vtx,boolean[] visited,int dest,String psf){
        if(vtx == dest){
           System.out.println(psf);
           return;
        }
        
        visited[vtx] = true;
        
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] == false){
                allPathHelper(graph,e.nbr,visited,dest,psf+e.nbr);
            }
        }
        
        visited[vtx] = false;
    }
    
    public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> allComps = new ArrayList<>();
        
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(!visited[vtx]){
                ArrayList<Integer> comp = new ArrayList<>();
                gccHelper(graph,vtx,comp,visited);
                
                allComps.add(comp); 
            }
        }
        
        return allComps;
    }
    
    public static void gccHelper(ArrayList<Edge>[] graph,int vtx,ArrayList<Integer> comp,boolean[] visited){
        visited[vtx] = true;
        comp.add(vtx);
        
        for(Edge e : graph[vtx]){
            if(!visited[e.nbr]){
                gccHelper(graph,e.nbr,comp,visited);
            }
        }
    }
 
    public static boolean isGraphConnected(ArrayList<Edge>[] graph){
        return gcc(graph).size() == 1;
    }
    
    public static int perfectFriends(ArrayList<Edge>[] graph){
        ArrayList<ArrayList<Integer>> allComps = gcc(graph);
        int ways = 0;
        for(int i = 0 ; i < allComps.size() ; i++){
            for(int j = i+1 ; j < allComps.size() ; j++){
                ways += (allComps.get(i).size() * allComps.get(j).size());
            }
        }
        return ways;
    }

    public static int numOfIslands(int board[][]) {
        int count = 0;
        for (int i = 0 ; i < board.length ; i++) {
          for (int j = 0 ; j < board[0].length ; j++) {
            if (board[i][j] == 0) {
              count++;
              numOfIslandsHelper(board, i, j); // mark whole island
            }
          }
        }
        return count;
    }

    public static void numOfIslandsHelper(int[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 1 || board[r][c] == 2) {
          return;
        }
    
    
        board[r][c] = 2;
        numOfIslandsHelper(board, r - 1, c); // north
        numOfIslandsHelper(board, r, c + 1); // east
        numOfIslandsHelper(board, r, c - 1); // west
        numOfIslandsHelper(board, r + 1, c); // south
    }

    public static void hamiltonian(ArrayList<Edge>[] graph,int vtx,String psf,boolean[] visited,int vsf,int osrc){
        visited[vtx] = true;
        
        if(vsf == graph.length){
            boolean directEdge = false;
            for(Edge e : graph[vtx]){
                if(e.nbr == osrc){
                    directEdge = true;
                    break;
                }
            }
            
            if(directEdge){
                //h. cycle
                System.out.println(psf+"*");
            }else{
                //h. path
                System.out.println(psf+".");
            }
        }
        
        for(Edge e : graph[vtx]){
            if(!visited[e.nbr]){
                hamiltonian(graph,e.nbr,psf+e.nbr,visited,vsf+1,osrc);
            }
        }
        
        visited[vtx] = false;
    }
    public static class BFSPair{
        int vtx;
        String psf;
        BFSPair(int vtx,String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
    public static void BFS(ArrayList<Edge>[] graph,int vtx){
        Queue<BFSPair> queue = new ArrayDeque<>();
        queue.add(new BFSPair(vtx, vtx+""));
        boolean[] vis = new boolean[graph.length];

        while(queue.size() > 0){
            BFSPair pair = queue.remove();

            if(!vis[pair.vtx]){
                vis[pair.vtx] = true;

                System.out.println(pair.vtx+"@"+pair.psf);

                for(Edge e : graph[pair.vtx]){
                    if(!vis[e.nbr]){
                        queue.add(new BFSPair(e.nbr, pair.psf+e.nbr));
                    }
                }
            }
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(!vis[vtx]){
                boolean res = isCyclicHelper(graph, vtx,vis); //  comp
                if(res){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclicHelper(ArrayList<Edge>[] graph,int vtx,boolean[] vis){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vtx);

        while(queue.size() > 0){
            int tvtx = queue.remove();
            if(vis[tvtx]){
                return true;
            }else{
                vis[tvtx] = true;
                for(Edge e : graph[tvtx]){
                    if(vis[e.nbr] == false){
                        queue.add(e.nbr);
                    }
                }
            }
        }

        return false;
    }

    public static class isBipartitePair{
        int vtx,level;
        isBipartitePair(int vtx,int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int visited[] = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int vtx = 0 ; vtx < graph.length ; vtx++){
            if(visited[vtx] == -1){
                boolean res = isBipartiteHelper(graph,vtx,visited);
                if(!res){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartiteHelper(ArrayList<Edge>[] graph,int vtx,int[] visited){
        Queue<isBipartitePair> queue = new ArrayDeque<>();
        queue.add(new isBipartitePair(vtx, 0));

        while(queue.size() > 0){
            isBipartitePair pair = queue.remove();

            if(visited[pair.vtx] == -1){
                visited[pair.vtx] = pair.level;

                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == -1){
                        queue.add(new isBipartitePair(e.nbr, pair.level+1));
                    }
                }
            }else{
                if(pair.level != visited[pair.vtx]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner  scn = new Scanner(System.in);

        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        // display(graph);     
        int src = scn.nextInt();
        int dest = scn.nextInt();

        System.out.println(hasPath(graph,src,dest));
    }
}

/*
7
8
0 3 40
0 1 10
1 2 10
2 3 10
3 4 4
4 5 3
5 6 3
4 6 8
*/
