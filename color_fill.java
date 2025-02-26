import java.util.*;
class COLOR{
    int v1,v2;
    COLOR(int u1,int u2){
        this.v1 = u1;
        this.v2 = u2;
    }
}
class color_fill{
public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the m and n: ");
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] matrix = new int[m][n];
    System.out.println("Fill the matrix: ");
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            matrix[i][j] = sc.nextInt();
        }
    }
    System.out.println("Enter the sr, sc and color: ");
    int Sr = sc.nextInt();
    int Sc = sc.nextInt();
    int color = sc.nextInt();
    int[][] result = bfs(matrix,Sr,Sc,color);
    for(int i = 0; i < result.length; i++){
        for(int j = 0; j < result[0].length; j++){
            System.out.print(result[i][j] + " ");
        }
        System.out.println();
    }
    sc.close();
}
public static int[][] bfs(int[][] matrix, int sr, int sc,int color){
    int start = matrix[sr][sc];
    if(color == start) return matrix;
    matrix[sr][sc] = color;
    Queue<COLOR> Q = new LinkedList<>();
    //COLOR COLOR = new COLOR(sr,sc);
    Q.add(new COLOR(sr,sc));
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    while(!Q.isEmpty()){
        COLOR p = Q.poll();
        int i = p.v1;
        int j = p.v2;
        for(int[] arr : dir){
            int row = i + arr[0];
            int col = j + arr[1];
            if(row >=0 && col>=0 && row < matrix.length && col < matrix[0].length && matrix[row][col] == start){
                matrix[row][col] = color;
                Q.add(new COLOR(row,col));
            }
        }
    }
    return matrix;
}
}