import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int arr[] = new int[n+1];
            int min = Integer.MAX_VALUE;
            int max = 0;

            int mid = l / 2;

            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(br.readLine());
                if(arr[j]>= mid) {
                    min = Math.min(min, arr[j]);
                }else {
                    max = Math.max(max, arr[j]);
                }
            }

            Arrays.sort(arr);

            sb.append(Math.max(l - min, max) + " " + Math.max(l - arr[1], arr[n])+"\n");
        }
        System.out.println(sb);
    }
}
