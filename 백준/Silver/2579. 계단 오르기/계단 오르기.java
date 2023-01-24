import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int [] score;
    public static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[301];
        score = new int[301];

        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];

        if (N >= 2){
            dp[2] = score[1]+score[2];
        }

        System.out.println(dpAlgorithm(N));
    }



    public static int dpAlgorithm(int n){

        if (dp[n]>0){
            return dp[n];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2],dp[i-3]+score[i-1])+score[i];
        }

        return dp[n];
    }
}
