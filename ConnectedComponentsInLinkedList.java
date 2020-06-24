import java.io.*;
import java.util.*;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; next = null; }

    public static ListNode createList(List<Integer> numbers) {
        if (numbers.size() == 0)
            return null;

        ListNode head = new ListNode(numbers.get(0));
        ListNode node = head;

        for (int i = 1; i < numbers.size(); ++i) {
            node.next = new ListNode(numbers.get(i));
            node = node.next;
        }

        return head;
    }

    public static List<Integer> extractList(ListNode head) {
        List<Integer> lst = new ArrayList<Integer>();

        while(head != null) {
            lst.add(head.val);
            head = head.next;
        }

        return lst;
    }
}

public class Solution {
    public ArrayList<ListNode> connectedComponents(ListNode head , int subset[]) {
        ArrayList<ListNode> result = new ArrayList<ListNode>();
        
        Set<Integer> set = new HashSet<>();
        for(int i : subset) set.add(i);
        
        ListNode currNode = head;
        
        while(currNode != null) {
            
            if(set.contains(currNode.val)) {
                result.add(currNode);
                ListNode prev = null;
                while(currNode != null && set.contains(currNode.val)){
                    prev = currNode;
                    currNode = currNode.next;
                }
                prev.next = null;
            }
            else {
                currNode = currNode.next;
            }
        }
        
        return result;
    }
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			list.add(x);
        }
        int m = scanner.nextInt();
        int subset[] = new int[m];
        for(int i = 0; i < m ; i++) {
            subset[i] = scanner.nextInt();
        }
        ListNode head = ListNode.createList(list);
        ArrayList<ListNode> result = new Solution().connectedComponents(head , subset);
        for(int i = 0 ; i < result.size() ; i++) {
            ListNode ptr = result.get(i);
            while(ptr != null) {
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
            System.out.println();
        }
    }
}