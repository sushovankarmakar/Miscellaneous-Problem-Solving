import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrimePolitics {

    private static boolean isSavingPossible(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjacencyList = getAdjacentList(n, edges);
        boolean[] isVisited = new boolean[n+1];
        int[] colorArr = new int[n+1];

        int startingNode = 0;
        for (int i = 1; i <= n; i++) {
            startingNode = i;
            if(!isVisited[startingNode]) {
               if(!checkBipartite(startingNode, 0, colorArr, isVisited, adjacencyList)) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartite(int currentNode, int color, int[] colorArr, boolean[] isVisited,
                                          List<List<Integer>> adjacencyList) {
        isVisited[currentNode] = true;
        colorArr[currentNode] = color;

        for (int adjNode : adjacencyList.get(currentNode)) {
            if(!isVisited[adjNode]) {
                if(!checkBipartite(adjNode, color^1, colorArr, isVisited, adjacencyList)) return false;
            }
            else if(colorArr[adjNode] == colorArr[currentNode]) {
                return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> getAdjacentList(int n, List<List<Integer>> edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int source = edge.get(0);
            int destination = edge.get(1);
            addEdges(adjacencyList, source, destination);
        }
        return adjacencyList;
    }

    private static void addEdges(List<List<Integer>> adjacencyList, int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] nm = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                edges.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                String[] edge = br.readLine().trim().split("\\s+");
                edges.get(i).add(Integer.parseInt(edge[0]));
                edges.get(i).add(Integer.parseInt(edge[1]));
            }

            System.out.println(isSavingPossible(n, edges) ? "SAVED" : "GONE");
        }
    }
}
