import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;

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
    }

    private static void solve() {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int middle = end - start - 1;
            int min = Math.min(arr[start], arr[end]);

            max = Math.max(max, min * middle);

            if (arr[start] < arr[end]){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(max);
    }
    
}