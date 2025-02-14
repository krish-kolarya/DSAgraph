import java.util.*;
class BFS_traversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++){
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edge (u1,v1): "); // An edge is between two vertices u and v
        for(int i = 0; i < e; i++){ // there are e number of edges
            int u1 = sc.nextInt();
            int v1 = sc.nextInt();
            adj.get(u1).add(v1);
            adj.get(v1).add(u1);
        }

        System.out.print(bfsofGraph(v,adj));
        sc.close();
    }
    static ArrayList<Integer> bfsofGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];

        q.add(0);
        vis[0] = true;

        while( !q.isEmpty()){
            Integer node = q.poll();
            result.add(node);

            for(Integer it : adj.get(node)){
                if(vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return result;
    }
}
