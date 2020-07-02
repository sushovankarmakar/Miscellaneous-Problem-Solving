import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.PriorityQueue;

class KthCharacter {
    static char findKthSmallest(String ip, int l, int r, int k) {
        Queue<Character> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        
        for(int i = l-1; i < r; i++) {
            maxHeap.offer(ip.charAt(i));
            //System.out.println("ROY " + maxHeap.peek());

            if(maxHeap.size() > k) {
                //System.out.println("HI " + maxHeap.peek());
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);
        String ip = br.readLine().trim();
		while(q-->0) {
            String[] lrk = br.readLine().trim().split("\\s+");
            int l = Integer.parseInt(lrk[0]);
            int r = Integer.parseInt(lrk[1]);
            int k = Integer.parseInt(lrk[2]);
            System.out.println(findKthSmallest(ip, l, r, k)); 
		}
    }
}
