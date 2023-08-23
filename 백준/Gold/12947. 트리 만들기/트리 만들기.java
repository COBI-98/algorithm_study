import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[] cnt;
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        cnt = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        cnt[0] = 1;

        for (int i = 1; i <= N; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int length = 0;
        int max = 0;

        // node == 1 -> 한 방향
        for (int i = N; i >= 0; i--) {
            if (cnt[i] == 1) {
                max = Math.max(max, N - i + length);
                length = 0;
            } else {
                length++;
            }
        }

        System.out.println(max);
    }
    
}