import java.io.*;
import java.util.*;

// Maximum Element hackerrank problem

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Stack<StackNode> stack = new Stack<StackNode>();
        int currMaxValue = Integer.MIN_VALUE;
        
        while(n-->0) {
            String[] ip = br.readLine().trim().split("\\s+");
            int type = Integer.parseInt(ip[0]);
            if(type == 1) {
                int x = Integer.parseInt(ip[1]);
                currMaxValue = Math.max(x, currMaxValue);
                stack.push(new StackNode(x, currMaxValue));
            }
            else if(type == 2) {
                stack.pop();
				
				// re-setting the max value
                if(stack.isEmpty()) currMaxValue = Integer.MIN_VALUE;
                else currMaxValue = stack.peek().currMaxValue;
            }
            else {
				if(!stack.isEmpty()) {
					System.out.println(stack.peek().currMaxValue);
				}
            }
        }
    }
    
    private static class StackNode {
        int value;
        int currMaxValue;
        StackNode(int value, int currMaxValue) {
            this.value = value;
            this.currMaxValue = currMaxValue;
        }
    }
}