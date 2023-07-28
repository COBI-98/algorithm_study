import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int [] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int[] temp = new int[N];

            for (int j = 0; j < N; j = j + 2) {
                if (N % 2 == 1) {
                    if (j == N - 1) {
                        temp[N / 2] = arr[j];
                    } else {
                        temp[j / 2] = arr[j];
                        temp[N - 1 - j / 2] = arr[j + 1];
                    }
                } else {
                    temp[j / 2] = arr[j];
                    temp[N - 1 - j / 2] = arr[j + 1];
                }
            }

            int maxDifference = Math.abs(temp[0] - temp[N - 1]);

            for (int j = 0; j < N - 1; j++) {
                int difference = Math.abs(temp[j] - temp[j + 1]);
                if (difference > maxDifference) {
                    maxDifference = difference;
                }
            }

            sb.append(maxDifference).append("\n");
        }

        System.out.println(sb);
    }

}