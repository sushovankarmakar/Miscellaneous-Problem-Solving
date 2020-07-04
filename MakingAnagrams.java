import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Making Anagrams hackerank problem

public class Solution {

    static int makingAnagrams(String s1, String s2) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char ch : s1.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0)+1);
        }
        
        for(char ch : s2.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0)-1);
        }
        
        int numCharsToBeDeleted = 0;
        for(int value : charFreqMap.values()) {
            numCharsToBeDeleted += Math.abs(value);
        }
        return numCharsToBeDeleted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
