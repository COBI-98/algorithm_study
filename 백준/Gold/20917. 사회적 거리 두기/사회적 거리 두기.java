import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    static int s;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
             st = new StringTokenizer(br.readLine());
             n = Integer.parseInt(st.nextToken());
             s = Integer.parseInt(st.nextToken());
             arr = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int start = 1;
            int end = arr[n];
            while (start <= end){
                int mid = (start + end)/2;
                int left = arr[1];
                int count = 1;
                count = lowerBound(mid, left, count);

                if (count >= s){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            sb.append(end + "\n");
        }

        System.out.println(sb);
    }

    private static int lowerBound(int mid, int left, int count) {
        for (int i = 2; i <= n; i++) {
            int right = arr[i];
            if (Math.abs(right- left) >= mid){
                count++;
                left = arr[i];
            }
        }
        return count;
    }
}
