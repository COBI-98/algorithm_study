import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int [] A;
    public static Integer [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N];
        dp = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


    }

    static int LIS(int depth) {

        if(dp[depth] == null) {
            dp[depth] = 1;	

            for(int i = depth - 1; i >= 0; i--) {
                if(A[i] < A[depth]) {
                    dp[depth] = Math.max(dp[depth], LIS(i) + 1);
                }
            }
        }
        return dp[depth];
    }
}
