import java.util.*;
class Pairr{
    int a,b;
    Pairr(int a,int b){
        this.a = a;
        this.b = b;
    }
}
public class numberOfEnclaves {
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
        int count = 0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Pairr> Q = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1){
                    if(matrix[i][j] == 1){
                        matrix[i][j] = 0;
                        Q.add(new Pairr(i,j));
                        bfs(Q,matrix,dir);
                    }
                }
            }
        }


        for(int i = 0; i < matrix.length; i++){
            for( int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);

        sc.close();
    }

    public static void bfs(Queue<Pairr> Q,int[][] matrix,int[][] dir){
        while(!Q.isEmpty()){
            Pairr p = Q.poll();
            for(int[] it : dir){
                int row = p.a + it[0];
                int col = p.b + it[1];
                if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == 1){
                    matrix[row][col] = 0;
                    Q.add(new Pairr(row,col));
                }
            }
        }
    }
}

/*
We mark all the 1s at the boundary as zero and add them to the queue.  So, all the 1s connected to this boundary will also be marked as
zero. Now, we will be left with those 1s that are not connected to the boundary 1s. 
 */