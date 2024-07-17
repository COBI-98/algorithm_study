import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N, answer;
    public static int[] nums = {1, 5, 10, 50};
    public static boolean[] visit = new boolean[1001];

    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0, 0);
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void solve(int depth, int idx, int sum) {
        if (depth == N) {
            if (!visit[sum]) {
                visit[sum] = true;
                answer++;
            }

            return;
        }

        for (int i = idx; i < 4; i++) {
            solve(depth + 1, i, sum + nums[i]);
        }
    }

    private static void printResult() {
        System.out.println(answer);
    }
}