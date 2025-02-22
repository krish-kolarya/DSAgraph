import java.util.*;
public class numberOfIslands {
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
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1},{1,1},{-1,1},{1,-1},{-1,-1}};
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    count++;
                    dfs(i,j,matrix,dir);
                }
            }
        }

        System.out.println("Count: " + count);
        sc.close();
    }
    public static void dfs(int i,int j,int[][] matrix,int[][] dir){
        matrix[i][j] = 0;
        for(int[] arr : dir){
            int row = arr[0] + i;
            int col = j + arr[1];
            if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == 1){
                dfs(row, col, matrix, dir);
            }
        }
    }
}
