import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] dist;
    public static int INF = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Bus>> arr = new ArrayList<>();

    static class Bus {
        int idx;
        int cost;

        public Bus(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++) {
            arr.add(new ArrayList<Bus>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.get(v).add(new Bus(e, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[arr.size()];
        Arrays.fill(dist, INF);

        System.out.println(dijkstra(start, end));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        pq.offer(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus curNode = pq.poll();

            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (int i = 0; i < arr.get(curNode.idx).size(); i++) {
                Bus nextNode = arr.get(curNode.idx).get(i);

                if (dist[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    // 갱신된 경우에만 큐에 넣는다.
                    pq.offer(new Bus(nextNode.idx, dist[nextNode.idx]));
                }

            }
        }

        return dist[end];
    }
}
