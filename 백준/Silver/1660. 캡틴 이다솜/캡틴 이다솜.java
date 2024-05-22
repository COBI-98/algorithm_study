import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[] dp1;
    static int[] dp2;
    static int[] answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp1 = new int[122];
        dp2 = new int[122];
        dp1[1] = 1;
        dp2[1] = 1;
        
        for (int i = 2; i < 122; i++) {
            dp1[i] = dp1[i - 1] + i;
            dp2[i] = dp1[i] + dp2[i - 1];
        }
        answer = new int[N + 1];
        
        Arrays.fill(answer, INF);
        answer[0] = 0;
        answer[1] = 1;
        for (int i = 2; i <= N; i++) {

            for (int j = 1; j < 122; j++) {
                if (dp2[j] > i) {
                    break;
                }
                answer[i] = Math.min(answer[i], answer[i - dp2[j]] + 1);
            }
        }
        System.out.println(answer[N]);
    }

}