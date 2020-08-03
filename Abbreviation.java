import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Hackerrank Abbreviation Problem

// https://www.youtube.com/watch?v=cl1rOsKxZOI
// https://medium.com/@awale8/abbreviation-hackerrank-medium-4601219c07d1 (Best Solution <- I followed this)
// https://stackoverflow.com/questions/4000169/getting-the-array-length-of-a-2d-array-in-java

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String str1, String str2) {
        
        boolean[][] isPossible = new boolean[str1.length() + 1][str2.length() + 1];
        
        isPossible[0][0] = true;
        
        for(int i = 1; i < isPossible[0].length; i++) {
            if(Character.isLowerCase(str1.charAt(i - 1))) {
                isPossible[i][0] = true;
            }
        }
        
        
        for(int i = 1; i < isPossible.length; i++) {
            for(int j = 1; j < isPossible[i].length; j++) {
                
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {  // char2 and char1 both can be upper case or both can be lowercase
                    isPossible[i][j] = isPossible[i - 1][j - 1];
                }
                else if(Character.toUpperCase(str1.charAt(i - 1)) == str2.charAt(j - 1)) {
                    isPossible[i][j] = isPossible[i - 1][j - 1] || isPossible[i - 1][j];
                }
                else if(str1.charAt(i - 1) != str2.charAt(j - 1) && Character.isUpperCase(str1.charAt(i - 1))) {
                    isPossible[i][j] = false;
                }
                else {
                    isPossible[i][j] = isPossible[i - 1][j];
                }
            }
        }
        
        return isPossible[str1.length()][str2.length()] ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
