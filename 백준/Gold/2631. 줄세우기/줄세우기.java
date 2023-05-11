import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(N - queueUp(N));
    }

    public static int queueUp(int x) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;            //해당 원소에서 끝나는 LIS 길이의 최솟값. 즉, 자기 자신
            for (int j = 0; j < i; j++) {
                //i번째 이전의 모든 원소에 대해, 그 원소에서 끝나는 LIS의 길이를 확인한다.
                if (arr[i] > arr[j]) {
                    //단, 이는 현재 수가 그 원소보다 클 때만 확인한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);        //dp[j] + 1 : 이전 원소에서 끝나는 LIS에 현재 수를 붙인 새 LIS 길이
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
