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
                if(dfsCycleDetection(adj, visited, it, current)){
                    return true;
                }
            }
            else if(it != parent){
                return true;
            }
        }
        return false;
    }
}
