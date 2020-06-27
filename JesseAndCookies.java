import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem

public class Solution {

    static int cookies(int k, int[] A) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : A) {
            minHeap.offer(num);
        }
        
        int numOfOperations = 0;
        
        while(minHeap.size() > 1 && minHeap.peek() < k) {
            int leastSweet = minHeap.poll();
            int secondLeast = minHeap.poll();
            
            int sweetness = (leastSweet + (2 * secondLeast));
            minHeap.offer(sweetness);
            numOfOperations++;
        }
        
        return (minHeap.peek() < k) ? -1 : numOfOperations;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
