public class L002PerfectFriends{
    public static class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList<Edge> graph[] = new ArrayList[vtces];

        for(int i = 0 ; i < vtces ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        System.out.println(perfectFriends(graph));
    }

    public static int perfectFriends(ArrayList<Edge> graph[]){
         ArrayList<ArrayList<Integer>> gcc = getAllConnectedComponents(graph);

         int count = 0;

         for(int i = 0 ; i < gcc.size() ; i++){
             for(int j = i+1 ; j< gcc.size() ; j++){
                 count += (gcc.get(i).size() * gcc.get(j).size());
             }
         }
         return count;
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
}