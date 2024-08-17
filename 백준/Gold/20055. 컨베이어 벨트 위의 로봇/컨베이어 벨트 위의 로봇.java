import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static boolean[] visit;
    static int[] containerBelt;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        containerBelt = new int[2 * N];
        visit = new boolean[2 * N];
        count = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N; i++) {
            containerBelt[(i + 1) % (2 * N)] = Integer.parseInt(st.nextToken());
        }

        while (count < K) {
            answer++;
            int tmp = containerBelt[0];
            for (int i = 2 * N - 1; i > 0; i--) {
                containerBelt[(i + 1) % (2 * N)] = containerBelt[i];
                if (i > 0 && i < N && visit[i]) {
                    visit[i + 1] = true;
                    visit[i] = false;
                }
            }
            visit[N] = false;
            containerBelt[1] = tmp;

            moveRobot();
            if (containerBelt[1] > 0) {
                visit[1] = true;
                containerBelt[1]--;
                if (containerBelt[1] == 0) {
                    count++;
                }
            }
        }

        System.out.println(answer);
    }

    static void moveRobot() {
        for (int i = N - 1; i > 0; i--) {
            if (visit[i] && !visit[i + 1] && containerBelt[i + 1] > 0) {
                visit[i + 1] = true;
                visit[i] = false;
                containerBelt[i + 1]--;
                if (containerBelt[i + 1] == 0) {
                    count++;
                }
            }
        }
        if (visit[N]) {
            visit[N] = false;
        }
    }
}