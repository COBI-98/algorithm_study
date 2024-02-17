import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;

        for (Integer child : adjList[idx]) {
            if (!visited[child]) {
                dfs(child);
                dp[idx][0] += dp[child][1];
                dp[idx][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
