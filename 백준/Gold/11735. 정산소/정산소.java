import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static final int MAXN = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        boolean[][] visited = new boolean[2][MAXN + 1];
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        long[] cnt = new long[2];
        long[] removed = new long[2];

        cnt[0] = cnt[1] = n;
        long base = ((long) n * (n + 1)) / 2; // 미리 계산하여 변수 지정

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            int idx = (query.equals("R")) ? 1 : 0;

            if (visited[idx][k]) {
                sb.append("0"+"\n");
            } else {
                visited[idx][k] = true;

                sb.append(cnt[idx] * k + base - removed[idx] + "\n");
                cnt[(idx + 1) % 2]--;
                removed[(idx + 1) % 2] += k;
            }
        }
        
        System.out.println(sb);
    }
}