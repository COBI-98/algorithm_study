import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] students;
    static int[] list;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        students = new int[N];
        list = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
            if (i != 0) {
                list[i - 1] = students[i] - students[i - 1];
            }
        }
    }

    private static void solve() {
        Arrays.sort(list);

        result = 0;
        for (int i = 0; i < N - K; i++) {
            result += list[i];
        }

        System.out.println(result);
    }
}