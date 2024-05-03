import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] first;
    static int[] second;
    static int[] third;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        first = new int[n];
        second = new int[n];
        third = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            first[i] = Integer.parseInt(st.nextToken());
            second[i] = Integer.parseInt(st.nextToken());
            third[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < n; r++) {
                    int canWin = 0;

                    for (int x = 0; x < n; x++) {
                        if (first[i] >= first[x] && second[j] >= second[x] && third[r] >= third[x]) {
                            canWin++;

                        }
                    }
                    if (canWin >= k) {
                        answer = Math.min(answer, first[i] + second[j] + third[r]);
                    }
                }
            }
        }
    }

    private static void printResult() {
        System.out.println(answer);
    }

}