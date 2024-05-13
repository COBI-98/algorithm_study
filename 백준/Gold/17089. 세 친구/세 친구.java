import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int[] visited_cnt;
	static boolean[][] visited;
	static int n;
	static int m;
	static StringTokenizer st;
	static BufferedReader br;
	static int result ;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
		init();
		result = INF;

		solve();

		if (result == INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
    }

    static void init() throws IOException {

        visited_cnt = new int[n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = true;
            visited[b][a] = true;
            visited_cnt[a] += 1;
            visited_cnt[b] += 1;
        }
    }

    static void solve() {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
				if (!visited[i][j]) {
					continue;
				}
                for (int k = 1; k < n + 1; k++) {
                    if (visited[i][k] && visited[k][j]) {
                        result = Math.min(visited_cnt[i] + visited_cnt[j] + visited_cnt[k] - 6, result);
                    }
                }
            }
        }
    }
}