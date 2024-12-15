import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;
    static int[] lenArray;
    static int maxLen = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        lenArray = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adjList.get(A).add(B);
            adjList.get(B).add(A);
        }

        bfs();

        int maxIdx = 0;
        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            if (lenArray[i] == maxLen) {
                if (maxIdx == 0) {
                    maxIdx = i;
                }
                maxCnt++;
            }
        }

        System.out.println(maxIdx + " " + maxLen + " " + maxCnt);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            maxLen = Math.max(maxLen, cur.len);
            lenArray[cur.vertex] = cur.len;

            for (int i = 0; i < adjList.get(cur.vertex).size(); i++) {
                int nextV = adjList.get(cur.vertex).get(i);

                if (visited[nextV]) {
                    continue;
                }

                q.offer(new Node(nextV, cur.len + 1));
                visited[nextV] = true;
            }
        }
    }

    static class Node {
        int vertex;
        int len;

        public Node(int vertex, int len) {
            this.vertex = vertex;
            this.len = len;
        }
    }
}