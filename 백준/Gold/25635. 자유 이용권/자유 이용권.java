import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    private static void solve() {
        long sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += arr[i];
        }

        long max = arr[N - 1];

        if (sum + 1 >= max) {
            System.out.println(sum + max);
        } else {
            System.out.println(2 * sum + 1);
        }
    }
}
