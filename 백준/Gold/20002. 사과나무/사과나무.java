import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] orchard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        orchard = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                orchard[i][j] = orchard[i - 1][j] + orchard[i][j - 1] + Integer.parseInt(st.nextToken())
                        - orchard[i - 1][j - 1];
            }
        }

        int ans = orchard[1][1];
        int size = 0;
        while (size++ < N) {
            for (int i = size; i < N + 1; i++) {
                for (int j = size; j < N + 1; j++) {
                    int sum = orchard[i][j] - orchard[i - size][j] - orchard[i][j - size] + orchard[i - size][j - size];
                    ans = Math.max(sum, ans);
                }
            }
        }

        System.out.println(ans);
    }
}
