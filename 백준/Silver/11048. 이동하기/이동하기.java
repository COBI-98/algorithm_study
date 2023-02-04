import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int [][] miro;
    public static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int [N+1][M+1];
        dp = new int [N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[1][1] = miro[1][1];

        System.out.println(running(N,M));
    }

    public static int running(int x, int y){

        if (dp[x][y] > 0){
            return dp[x][y];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + miro[i][j], Math.max(dp[i-1][j] + miro[i][j], dp[i][j-1] + miro[i][j]));
            }
        }


        return dp[x][y];
    }
}
