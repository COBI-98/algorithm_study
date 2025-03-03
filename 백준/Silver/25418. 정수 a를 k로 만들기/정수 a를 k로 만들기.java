import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[a] = 0;
        for (int i = a; i < k + 1; i++) {
            if (i + 1 <= k) {
                arr[i + 1] = Math.min(arr[i] + 1, arr[i + 1]);
            }
            if (i * 2 <= k) {
                arr[i * 2] = Math.min(arr[i] + 1, arr[i * 2]);
            }
        }

        System.out.println(arr[k]);
    }
}