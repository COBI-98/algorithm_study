import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][2];
        int[] dp = new int[N + 1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arr[i][0] = time;
            arr[i][1] = pay;
        }

        int max = -1;
        for(int i = 0; i <= N; i++){
            if(max < dp[i]){
                max = dp[i];
            }
            int next = i + arr[i][0];
            if(next <= N){
                dp[next] = Math.max(dp[next], max + arr[i][1]);
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}