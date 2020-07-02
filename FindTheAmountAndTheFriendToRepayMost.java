import java.util.*;

class pair{
    String Name;
    Long Money;
    pair(String Name, Long Money){
        this.Name = Name;
        this.Money = Money;
    }
}

public class MaxDebt {
    static pair maxdebt(int n, ArrayList<pair>money){
        //Queue<Integer> minHeap = new PriorityQueue<>();
        Map<String, Queue<Long>> map = new HashMap<>();

        for(pair m : money) {
            if(map.containsKey(m.Name)) {
                Queue<Long> minHeap = map.get(m.Name);

                minHeap.offer(m.Money);

                if(minHeap.size() > 3) {
                    minHeap.poll();
                }
            }
            else {
                Queue<Long> minHeap = new PriorityQueue<>();
                minHeap.offer(m.Money);

                map.put(m.Name, minHeap);
            }
        }

        String maxName = "";
        long maxValue = Long.MIN_VALUE;

        for(String name : map.keySet()) {
            Queue<Long> minHeap = map.get(name);
            long total = getTotal(minHeap);
            if(maxValue <= total) {
                maxName = name;
                maxValue = total;
            }
        }

        pair p = new pair(maxName, maxValue);
        return p;
    }

    private static long getTotal(Queue<Long> minHeap) {
        long total = 0;
        while(minHeap.peek() != null) {
            total += minHeap.poll();
        }
        return total;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; ++t) {
            int n = scanner.nextInt();
            ArrayList<pair> money = new ArrayList<pair>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                Long amt = scanner.nextLong();
                pair P = new pair(s,amt);
                money.add(P);    
            }
            pair P = maxdebt(n,money);
            System.out.printf("%s %d\n", P.Name, P.Money);
        }
    }
}
