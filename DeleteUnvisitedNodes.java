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
  // Complete the following function

    void deleteUnvisitedNodes(ListNode head) {
        if(head == null) return;
        
        ListNode currNode = head;
        int count = head.val;
        
        while(currNode != null) {
            count = currNode.val;
            
            while(count > 1 && currNode.next != null) {
                ListNode temp = currNode.next;
                currNode.next = currNode.next.next;
                temp = null;
                
                count--;
            }
            
            currNode = currNode.next;
        }
        
    }
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; ++i) {
            int x = scanner.nextInt();
            list.add(x);
        }
        ListNode head = ListNode.createList(list);
        new Solution().deleteUnvisitedNodes(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

