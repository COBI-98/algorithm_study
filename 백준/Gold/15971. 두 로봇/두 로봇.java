import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int N, roomA, roomB;

    static ArrayList<Edge>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        roomA = Integer.parseInt(st.nextToken());
        roomB = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int dist = getDist(roomA, 0);

        int maxWeight = getMaxWeight(roomA, 0);

        System.out.println(dist - maxWeight);
    }

    static int getDist(int curNode, int prevNode) {
        if (curNode == roomB) {
            return 0;
        }
        for (Edge next : graph[curNode]) {
            if (next.node == prevNode) {
                continue;
            }
            int dist = getDist(next.node, curNode);
            if (dist < 0) {
                continue;
            }
            return next.weight + dist;
        }
        return -1;
    }

    static int getMaxWeight(int curNode, int prevNode) {
        if (curNode == roomB) {
            return 0;
        }
        for (Edge next : graph[curNode]) {
            if (next.node == prevNode) {
                continue;
            }
            int maxWeight = getMaxWeight(next.node, curNode);
            if (maxWeight < 0) {
                continue;
            }
            return Math.max(next.weight, maxWeight);
        }
        return -1;
    }

    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}