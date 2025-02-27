import java.util.*;
class bipartite_graph {
    public static void main(String[] args){
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        isBipartite(graph);
    }
    static boolean isBipartite(int[][] graph) { // graph here is the adj list
        int v = graph.length; // stores the number of vertices
        int[] visited = new int[v]; // visited array
        int color = -1; // The idea is to give color to every node either 1 or -1 and then check if the two vertices of an edge are colored different or not
        Queue<Integer> Q = new LinkedList<>(); // BFS Traversal, Queue stores the nodes

        for(int i = 0; i < v; i++){ // We have to ensure that all the nodes are visited
            if(visited[i] == 0){ // If a node is found to not visited
                visited[i] = color; // visit it and color it
                Q.add(i); // add it to the queue
                if (bfs(Q,graph,visited,color) == false){ // perform bfs to color its neighbors with a different color
                System.out.print(false);
                return false;
            }
            }
        }

        System.out.print(true);
        return true;
    }
    static boolean bfs(Queue<Integer> Q,int[][] graph,int[] visited,int color){
        while(!Q.isEmpty()){
            Integer node = Q.poll();
            color = visited[node] * -1; // The color of the neighbors of the root node should be negatively inverse of the root node
            for(int it : graph[node]){ // visit all the neighbors and add them to the queue
                if(visited[it] == 0){ 
                    visited[it] = color;
                    Q.add(it);
                } else if (visited[it] == visited[node]){ // if node color and neighbor color is same then return false;
                    return false;
                }
            }
        }
        return true;
    }
}