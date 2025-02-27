import java.util.*;
class cycleDetectGraph{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }

        
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        for(int i = 0; i < e; i++){
            int u1 = sc.nextInt();
            int u2 = sc.nextInt();
            adjList.get(u1).add(u2);
        }

        boolean ans = isCyclic(adjList);
        if(ans) System.out.println("Cycle is detected");
        else System.out.println("Cycle not detected");
        sc.close();
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        // code here
        int[] visited = new int[v];
        int[] path = new int[v];
        for(int i = 0; i < v; i++){
            if(visited[i] == 0){
                if(dfs(adj,visited,path,i)) return true;
            }
        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int[] path,int node){
        visited[node] = 1;
        path[node] = 1;
        for(Integer it : adj.get(node)){
            if(visited[it] == 0){
                if(dfs(adj,visited,path,it) == true) return true;
            }
            else if(path[it] == 1) return true;
        }
        path[node] = 0;
        return false;
    }
}