import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cnt;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }

        cnt = new int[N+1];

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            cnt[idx] += w;
        }

        for(int i=2; i<=N; i++) {
            cnt[i] += cnt[parent[i]];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.print(sb);
    }


}
