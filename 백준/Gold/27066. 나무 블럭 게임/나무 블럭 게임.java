import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(solve());
        
    }

    private static double solve() {
        if (N == 1) {
            return arr[0];
        }

        double maxAvg = 0.0;
        double sum = 0.0;
        int cnt = 0;
        for (int i = N - 2; i > 0; i--) {
            sum += arr[i];
            maxAvg = Math.max(maxAvg, sum / ++cnt);
        }

        sum += arr[0] + arr[N - 1];
        maxAvg = Math.max(maxAvg, sum / N);

        return maxAvg;
    }

}
