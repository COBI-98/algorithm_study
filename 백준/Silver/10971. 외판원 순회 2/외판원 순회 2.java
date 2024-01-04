import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            solve(i, i, 0, 0);
        }
        System.out.println(answer);

    }

    public static void solve(int start, int now, int sum, int cnt) {
        if (cnt == n - 1) { 
            if (map[now][start] != 0) {
                sum += map[now][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                solve(start, i, sum + map[now][i], cnt + 1);
                visit[i] = false;
            }

        }
    }
}