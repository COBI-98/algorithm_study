import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int arr[];
    static int minHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int low = 0;
        int high = N;

        while(low < high) {
            int mid = (low + high) / 2;
            int current = 0;

            for (int c : arr) {
                int start = c - mid;
                int end = c + mid;

                if (current < start) {
                    break;
                } else {
                    current = end;
                }
            }
            if (N <= current) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        System.out.println(low);
    }

}
