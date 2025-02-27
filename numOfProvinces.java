import java.util.*;
public class numOfProvinces {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int m = sc.nextInt();

        int[][] isConnected = new int[m][m];

        System.out.println("Enter the matrix values (0,1): ");

        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                isConnected[i][j] = sc.nextInt();
            }
        }
        System.out.println(function(isConnected));
        sc.close();
    }

    public static void dfs(int start, ArrayList<ArrayList<Integer>> adjList,boolean[] visited){
        visited[start] = true;
        for(Integer it : adjList.get(start)){
            if(visited[it] == false){
                dfs(it,adjList,visited);
            }
        }
    }

    public static int function(int[][] isConnected){

        int count = 0;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int V = isConnected.length;
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i!=j){ // an edge cannot be because of a single node
                    adjList.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < V; i++){
            if(visited[i] == false){
                count++;
                dfs(i,adjList,visited);
            }
        }

        return count;
    }
}
