import java.util.*;
public class dfsCycleDetect {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter the edges (u,v): ");
        for(int i = 0; i < e; i++){
            int u1 = sc.nextInt();
            int u2 = sc.nextInt();
            adj.get(u1).add(u2);
            adj.get(u2).add(u1);
        }
        int[] visited = new int[v];
        int parent = -1;
        for(int i = 0; i < v; i++){
            if(visited[i] == 0){
                if(dfsCycleDetection(adj,visited,i,parent)){
                    System.out.println(true);
                    sc.close();
                    return;
                }
            }
        }
        System.out.println(false);
        sc.close();
    }
    public static boolean dfsCycleDetection(ArrayList<ArrayList<Integer>> adj,int[] visited,int current,int parent){
        visited[current] = 1;
        for(Integer it : adj.get(current)){
            if(visited[it] == 0){
                if(dfsCycleDetection(adj, visited, it, current)){ // if we have already found a cycle
                    return true;
                }
            }
            else if(visited[it] == 1 && it != parent){ // if the node we want to go to is already visited and it is not same as our current node's parent then we have found a cycle.
                return true;
            }
        }
        return false; // we did not find a cycle yet
    }
}