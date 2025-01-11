import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int[] days;
    static int[] pages;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        days = new int[M + 1];
        pages = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pages[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[M + 1][N + 1];
    }
    
    private static void solve() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int day = days[i];
                int page = pages[i];
                dp[i][j] = (j < day) ? dp[i - 1][j] : Math.max(dp[i - 1][j], dp[i - 1][j - day] + page);
            }
        }
    }
    
    private static void printResult() {
        System.out.println(dp[M][N]);
    }
}