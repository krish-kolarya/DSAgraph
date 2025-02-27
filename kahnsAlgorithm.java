import java.util.*;

public class kahnsAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        System.out.println("Enter the number of edges: ");
        int e = sc.nextInt();

        // Initialize the adjacency list for each vertex.
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Fill the adjacency list (enter edge endpoints): ");
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
        }

        // Get the topologically sorted order.
        ArrayList<Integer> result = topologicalSort(adj);

        // Print the topological order.
        System.out.println("Topological Order:");
        for (Integer node : result) {
            System.out.print(node + " ");
        }
        sc.close();
    }

    // This method performs topological sort using Kahn's Algorithm.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int[] indegree = new int[v];  // Array to store indegree of each vertex.
        ArrayList<Integer> result = new ArrayList<>();

        // Calculate indegree for each vertex.
        for (int i = 0; i < v; i++) {
            for (Integer neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Initialize a queue and add all vertices with indegree 0.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the vertices in the queue.
        while (!queue.isEmpty()) {
            int front = queue.poll();
            result.add(front);

            // For each neighbor of the current vertex, reduce its indegree.
            for (Integer neighbor : adj.get(front)) {
                indegree[neighbor]--;
                // If indegree becomes 0, add the neighbor to the queue.
                if (indegree[neighbor] == 0) 
                    queue.add(neighbor);
            }
        }
        return result;
    }
}