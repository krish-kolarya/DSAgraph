import java.util.*;
public class topologicalSorting {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    System.out.println("Enter the number of vertices: ");
    int v = sc.nextInt();
    System.out.println("Enter the number of edges: ");
    int e = sc.nextInt();

    for(int i = 0; i < v; i++){
        adj.add(new ArrayList<>());
    }

    System.out.println("Fill the adjacency list: ");

    for(int i = 0; i < e; i++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        adj.get(x).add(y);
    }

    ArrayList<Integer> result = topologicalSort(adj);
    
    for(int i = 0; i < result.size(); i++){
        System.out.print(result.get(i) + " ");
    }
    sc.close();
   }

   static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
    // Your code here
    int v = adj.size();
    int[] visited = new int[v];
    Stack<Integer> stk = new Stack<>();
    for(int i = 0; i < v; i++){
        if(visited[i] == 0){
            visited[i] = 1;
            dfs(adj,visited,stk,i);
        }
    }
    ArrayList<Integer> result = new ArrayList<>();
    while(!stk.isEmpty()){
        int num = stk.pop();
        result.add(num);
    }
    return result;
}

static void dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> stk,int node){
    for(Integer it : adj.get(node)){
        if(visited[it] == 0){
            visited[it] = 1;
            dfs(adj,visited,stk,it);
        }
    }
    stk.push(node);
}
}