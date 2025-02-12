import java.util.*;
class BFS_traversal {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        bfsofGraph(v,adj);
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
