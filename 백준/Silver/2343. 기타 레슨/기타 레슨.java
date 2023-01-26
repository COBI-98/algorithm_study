import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 10 20 30 40 45
    public static int N;
    public static int M;
    public static int[] lecture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N];
        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right =0;
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            right += lecture[i];
            left = Math.max(left,lecture[i]);
        }
        while (left <= right) {
            int mid = (left + right) / 2;

            int count = getCount(N, lecture, mid);

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }


    private static int getCount(int n, int[] lecture, int mid) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + lecture[i] > mid) {
                sum = 0;
                count++;
            }
            sum += lecture[i];
        }

        if (sum != 0) {
            count++;
        }
        return count;
    }
}
