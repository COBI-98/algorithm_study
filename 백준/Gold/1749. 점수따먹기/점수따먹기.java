import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] matrix;
    static int[][] prefix;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        calculatePrefixSum();
        System.out.println(solve());
    }

    private static int solve() {
        for (int row1 = 1; row1 <= N; row1++) {
            for (int col1 = 1; col1 <= M; col1++) {

                for (int row2 = row1; row2 <= N; row2++) {
                    for (int col2 = col1; col2 <= M; col2++) {
                        int result = calculateRangeSum(row1, col1, row2, col2);
                        max = Math.max(max,result);
                    }
                }
            }
        }
        return max;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int calculateRangeSum(int row1, int col1, int row2, int col2) {
        return prefix[row2][col2] - prefix[row1 - 1][col2] - prefix[row2][col1 - 1] + prefix[row1 - 1][col1 - 1];
    }

    private static void calculatePrefixSum() {
        prefix = new int[N + 1][M + 1];

        prefix[0][0] = matrix[0][0];

        for (int i = 1; i <= N; i++) {
            prefix[i][0] = prefix[i - 1][0] + matrix[i - 1][0];
        }

        for (int j = 1; j <= M; j++) {
            prefix[0][j] = prefix[0][j - 1] + matrix[0][j - 1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
    }
    
}