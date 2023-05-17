import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (K >= N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        int sum = 0;

        int[] difArr = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            difArr[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(difArr);

        // N-1 - (K -1)
        for (int i = 0; i < N-K; i++) {
            sum += difArr[i];
        }

        System.out.println(sum);
    }
}
