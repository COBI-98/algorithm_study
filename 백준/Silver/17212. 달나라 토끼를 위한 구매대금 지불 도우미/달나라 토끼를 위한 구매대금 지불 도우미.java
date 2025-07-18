import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
    }

    static void solve() {
        if (N == 0) {
            System.out.print(0);
            return;
        }

        if (N == 1 || N == 2 || N == 5 || N == 7) {
            System.out.print(1);
            return;
        }

        if (N == 3 || N == 4 || N == 6) {
            System.out.print(2);
            return;
        }

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 1;
        arr[6] = 2;
        arr[7] = 1;

        for (int i = 8; i <= N; i++) {
            arr[i] = Math.min(arr[i - 1], arr[i - 2]);
            arr[i] = Math.min(arr[i], arr[i - 5]);
            arr[i] = Math.min(arr[i], arr[i - 7]) + 1;
        }

        System.out.print(arr[N]);
    }
}