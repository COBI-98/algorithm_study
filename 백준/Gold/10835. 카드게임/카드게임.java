import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] leftCard;
    static int[] rightCard;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(0, 0));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        leftCard = new int[N];
        rightCard = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            leftCard[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, leftCard[i]);
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            rightCard[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int solve(int lIdx, int rIdx) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        if (lIdx == N || rIdx == N) {
            return 0;
        }

        if (dp[lIdx][rIdx] != -1) {
            return dp[lIdx][rIdx];
        }

        // 카드 두개 다 버리거나, 왼쪽 카드를 버리는 경우 중 큰 수
        dp[lIdx][rIdx] = Math.max(solve(lIdx + 1, rIdx + 1), solve(lIdx + 1, rIdx));

        // 만약 오른쪽 카드가 더 작다면 연산을 한번 더 해줌. 이 경우에는 오른쪽 카드 값을 더해서 계산
        if (leftCard[lIdx] > rightCard[rIdx]) {
            dp[lIdx][rIdx] = Math.max(dp[lIdx][rIdx], solve(lIdx, rIdx + 1) + rightCard[rIdx]);
        }

        return dp[lIdx][rIdx];
    }
}
