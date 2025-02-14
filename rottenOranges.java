import java.util.*;
public class rottenOranges {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int n = sc.nextInt();
        System.out.println("Enter the matrix: ");
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(function(matrix));
        sc.close();
    }
    public static int function(int[][] matrix){
        int time = 0;
        Queue<ArrayList<Integer>> Q = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 2){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    arr.add(time);
                    Q.add(arr);
                }
            }
        }

        while(!Q.isEmpty()){
            int len = Q.size();
            boolean flag = false;
            for(int k = 0; k < len; k++){
                ArrayList<Integer> arr = Q.poll();
                int i = arr.get(0);
                int j = arr.get(1);
                if(isValid(i+1,j,matrix) == true){
                    flag = true;
                    matrix[i+1][j] = 2;
                    addList(i+1,j,time,Q);
                }
                if(isValid(i-1,j,matrix) == true){
                    flag = true;
                    matrix[i-1][j] = 2;
                    addList(i-1,j,time,Q);
                }
                if(isValid(i,j+1,matrix) == true){
                    flag = true;
                    matrix[i][j+1] = 2;
                    addList(i,j+1,time,Q);
                }
                if(isValid(i,j-1,matrix) == true){
                    flag = true;
                    matrix[i][j-1] = 2;
                    addList(i,j-1,time,Q);
                }
            }
            if(flag == true) time++;
        }
        if(validMatrix(matrix) == true) return time;
        return -1;
    }
    public static boolean isValid(int i,int j,int[][] matrix){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0 || matrix[i][j] == 2) return false;
        return true;
    }
    public static void addList(int i ,int j,int time,Queue<ArrayList<Integer>> Q){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(i);
        arr.add(j);
        arr.add(time);
        Q.add(arr);
    }
    public static boolean validMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1) return false;
            }
        }
        return true;
    }
}
