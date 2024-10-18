import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int K;
    static int[] list;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];
        dp = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < N ; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        if (dp[N-1] == 1) System.out.println("YES");
        else System.out.println("NO");
    }
    static void solve() {
        dp[0] = 1;
        for (int i = 0 ; i < N-1 ; i++) {
            if (dp[i] == 1) {
                for (int j = i + 1; j < N; j++) {
                    if ((j - i) * (1 + Math.abs(list[i] - list[j])) <= K) {
                        dp[j] = 1;
                    }
                }
            }
        }
    }
}