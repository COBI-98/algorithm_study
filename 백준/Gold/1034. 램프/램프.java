import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] map = new int[51][51];
    static int count;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        k = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            int zeroCount = 0;
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    zeroCount++;
                }
            }

            int samePattern = 0;
            if (zeroCount <= k && zeroCount % 2 == k % 2) {
                for (int j = 1; j <= n; j++) {
                    if (isSame(map[i], map[j], m)) {
                        samePattern++;
                    }
                }
            }
            count = Math.max(count, samePattern);
        }
    }

    public static boolean isSame(int[] arr, int[] arr2, int m) {
        for (int i = 1; i <= m; i++) {
            if (arr[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printResult() {
        System.out.println(count);
    }
}