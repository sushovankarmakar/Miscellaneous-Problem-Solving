import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static int maxRegion = 0;
    
    static int connectedCell(int[][] matrix) {
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 1) {
                    int region = dfs(matrix, row, col, 1);
                    maxRegion = Math.max(maxRegion, region);
                }
            }
        }
        return maxRegion;
    }
    
    private static int dfs(int[][] matrix, int row, int col, int region) {
        matrix[row][col] = 2;
        
        int[][] directions = { {0, -1}, {1, -1}, {1,0}, {1, 1},
                             {0, 1}, {-1, 1}, {-1, 0}, {-1, -1} };
        
        for(int[] direction : directions) {
            int adjRow = row + direction[0];
            int adjCol = col + direction[1];
            
            if(isValidAndConnected(matrix, adjRow, adjCol)) {
                matrix[adjRow][adjCol] = 2;
                region = dfs(matrix, adjRow, adjCol, region + 1);
            }
        }
        return region;
    }

    private static boolean isValidAndConnected(int[][] matrix, int row, int col) {
        return (0 <= row && row < matrix.length) && (0 <= col && col < matrix[row].length) && (matrix[row][col] == 1);
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);
        maxRegion = 0;

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
