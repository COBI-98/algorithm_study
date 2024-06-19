import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        ans = 0;

        dfs(500, 0);
        System.out.println(ans);
    }

    private static void dfs(int sum, int cnt) {
        if(cnt == N) {
            ans++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i] && sum + arr[i] - K >= 500) {
                visited[i] = true;
                dfs(sum + arr[i] - K, cnt + 1);
                visited[i] = false;
            }
        }

    }
}