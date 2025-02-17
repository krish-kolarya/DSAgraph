import java.util.*;
public class bfsCycleDetect {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }
        System.out.println("Fill the adjacency list: ");
        for(int i = 0; i < e; i++){
            int u1 = sc.nextInt();
            int v1 = sc.nextInt();
            adjList.get(u1).add(v1);
            adjList.get(v1).add(u1);
        }
        int[] visited = new int[adjList.size()];
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(0,-1));
        boolean flag = false;
        for(int i = 0; i < v; i++){
            if(visited[i] == 0 && function(adjList,visited,Q) == true){
                flag = true;
            }
        }
        System.out.print(flag);
        sc.close();
    }
    public static boolean function(ArrayList<ArrayList<Integer>> adjList,int [] visited,Queue<Pair> Q){
        while(!Q.isEmpty()){
            Pair p = Q.poll();
            int node = p.r;
            int parent = p.parent;
            for (Integer neighbor : adjList.get(node)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    Q.add(new Pair(neighbor,node));
                } else if (neighbor != parent) {
                    return true; // Cycle detected
                }
            }
        }
        return false;
    }
}
class Pair{
    int r,parent;
    Pair(int r,int parent){
        this.r = r;
        this.parent = parent;
    }
}