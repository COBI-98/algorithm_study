import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<ArrayList<SubwayInfo>> list = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        System.out.println(dist[N]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list.get(A).add(new SubwayInfo(B, T, W));
        }
    }

    private static void dijkstra() {
        PriorityQueue<SubwayInfo> pq = new PriorityQueue<>();
        pq.offer(new SubwayInfo(1, 0, 0));

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[1] = 0;

        while (!pq.isEmpty()) {
            SubwayInfo cur = pq.poll();

            if (cur.t > dist[cur.idx]) {
                continue;
            }

            for (SubwayInfo next : list.get(cur.idx)) {
                int wait = cur.t % next.delay == 0 ? 0 : next.delay - cur.t % next.delay;
                int estimatedTime = wait + cur.t + next.t;

                if (dist[next.idx] > estimatedTime) {
                    dist[next.idx] = estimatedTime;
                    pq.offer(new SubwayInfo(next.idx, estimatedTime, 0));
                }
            }
        }
    }

    static class SubwayInfo implements Comparable<SubwayInfo> {

        int idx;
        int t;
        int delay;

        public SubwayInfo(int idx, int t, int w) {
            this.idx = idx;
            this.t = t;
            this.delay = w;
        }

        @Override
        public int compareTo(SubwayInfo o) {
            return this.t - o.t;
        }
    }

}