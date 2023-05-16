import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int [] arr = new int[100];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; i++) {
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }

            sb.append("#"+tc+" "+(arr[99]-arr[0])+"\n");
        }

        System.out.println(sb);
    }
}
