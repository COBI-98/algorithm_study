import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] targetColor;
    static int[] treeColor;
    static boolean[] visited;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        init();
        System.out.println(solve());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        targetColor = new int[N];
        adjList = new ArrayList[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            targetColor[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            adjList[p].add(c);
            adjList[c].add(p);
        }

        treeColor = new int[N];
        visited = new boolean[N];
    }

    private static int solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (treeColor[cur] != targetColor[cur]) {
                treeColor[cur] = targetColor[cur];
                cnt++;
            }

            for (int i = 0; i < adjList[cur].size(); i++) {
                int idx = adjList[cur].get(i);
                if (visited[idx]) {
                    continue;
                }
                treeColor[idx] = treeColor[cur];
                visited[idx] = true;
                queue.add(idx);
            }
        }
        return cnt;
    }
}