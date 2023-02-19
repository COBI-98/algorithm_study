import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int A;
    public static int B;
    public static int v;
    public static int[][] map;
    public static int[] visit;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visit = new int[n + 1];

        v = Integer.parseInt(br.readLine());
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        bfs(A,B);

        if (visit[B] == 0){
            System.out.println(-1);
        }else{
            System.out.println(visit[B]);
        }

    }

    public static void bfs(int start , int end) {
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end){
                break;
            }
            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0 && map[cur][i] == 1) {
                    visit[i] = visit[cur] + 1;
                    q.offer(i);
                }
            }
        }
    }
}
