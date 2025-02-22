import java.util.*;
class Pairs {
    int x, y, dist;
    Pairs(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class zeroOneMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        System.out.println("Fill the matrix: ");

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] result = new int[m][n];
        result = updateMatrix(matrix);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pairs> Q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    Q.add(new Pairs(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!Q.isEmpty()) {
            Pairs p = Q.poll();
            for (int[] dir : directions) {
                int row = p.x + dir[0];
                int col = p.y + dir[1];
                
                if (row >= 0 && col >= 0 && row < m && col < n && !visited[row][col]) {
                    ans[row][col] = p.dist + 1;
                    visited[row][col] = true;
                    Q.add(new Pairs(row, col, p.dist + 1));
                }
            }
        }

        return ans;
    }
}
