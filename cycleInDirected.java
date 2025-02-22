import java.util.*;

class CycleInDirected {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.println("Enter the adjacency matrix (0 or 1 values): ");

        int[][] matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        // We converted the matrix to array list
        System.out.println(hasCycle(graph, vertices) ? "Cycle detected" : "No cycle detected");
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int vertices) {
        int[] visited = new int[vertices];
        int[] pathVisited = new int[vertices];
        //we check for each and every node for cyclicity by taking them as start node.
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) {
                // If the dfs ever returns true then here also we return true
                if (dfs(graph, visited, pathVisited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int[] pathVisited, int node) {
        // start by marking both the visited and pathvisited as 1
        visited[node] = 1; // have we ever visited the node or not
        pathVisited[node] = 1; // the node is a part of the current path or not

        for (int neighbor : graph.get(node)) {
            if (visited[neighbor] == 0) { // if the node has not been visited then start dfs traversal on it and check for cyclicity
                if (dfs(graph, visited, pathVisited, neighbor)) { 
                    return true;
                }
            } else if (pathVisited[neighbor] == 1) { // if the node is visited and also a part of the path, cycle exists
                return true;
            }
        }

        pathVisited[node] = 0; // if none of the neighbors of current node can be traversed then remove this node from path
        return false;
    }
}