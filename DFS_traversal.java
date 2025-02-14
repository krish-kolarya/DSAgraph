import java.util.*;
public class DFS_traversal {
     public static void main(String args[]){

        System.out.println("Enter the number of vertices: ");
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;  i < V; i++){
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter the edges (u,v): ");

        for(int i = 0; i < e; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int start = 0;
        boolean [] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(dfs(start,visited,adj,result));
        sc.close();
    }
    public static ArrayList<Integer> dfs(int start,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result){
        visited[start] = true;
        result.add(start);
        for(Integer it : adj.get(start)){
            if(visited[it] == false){
                dfs(it,visited,adj,result);
            }
        }
        return result;
    }
}