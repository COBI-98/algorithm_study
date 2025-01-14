import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int idx;
    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        
        idx = 0;
        cnt = n;
        while (cnt >= k) {
            int temp = 1;
            while (temp < k) {
                idx = (idx + 1) % n;
                if (!visited[idx]) {
                    visited[idx] = true;
                    temp++;
                    cnt--;
                }
            }
            
            for (int i = 1; i < n; i++) {
                if (visited[(idx + i) % n]) {
                    continue;
                }
                idx = (idx + i) % n;
                break;
            }
        }
        System.out.println(idx + 1);
    }
}