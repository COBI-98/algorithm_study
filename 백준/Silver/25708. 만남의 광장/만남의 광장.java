import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] rowSum;
    static int[] colSum;

    public static void main(String[] args) throws IOException {
        input();
        calculatePrefixSum();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calculatePrefixSum() {
        rowSum = new int[N];
        colSum = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                rowSum[i] += map[i][j];
                colSum[j] += map[i][j];
            }
        }
    }

    private static void solve() {
        int answer = Integer.MIN_VALUE;

        for (int x1 = 0; x1 < N - 1; x1++) {
            for (int x2 = x1 + 1; x2 < N; x2++) {
                for (int y1 = 0; y1 < M - 1; y1++) {
                    for (int y2 = y1 + 1; y2 < M; y2++) {
                        int duplicate = map[x1][y1] + map[x1][y2] + map[x2][y1] + map[x2][y2];
                        int result = rowSum[x1] + rowSum[x2] + colSum[y1] + colSum[y2] - duplicate + ((x2 - x1 - 1) * (y2 - y1 - 1));
                        answer = Math.max(answer, result);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
