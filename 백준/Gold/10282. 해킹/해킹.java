import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int T, n, d, c;
    static ArrayList<int[]>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++)
                graph[i] = new ArrayList<>();
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }
            sb.append(solve(c)).append('\n');
        }
        System.out.println(sb);
    }
    
    static String solve(int start) {
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curIdx = cur[0];
            int curTime = cur[1];
            if (curTime > dist[curIdx])
                continue;
            for (int[] next : graph[curIdx]) {
                int nextIdx = next[0];
                int nextTime = next[1];
                if (dist[nextIdx] > curTime + nextTime) {
                    dist[nextIdx] = curTime + nextTime;
                    pq.offer(new int[]{nextIdx, dist[nextIdx]});
                }
            }
        }
        int cnt = 0, maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                cnt++;
                maxTime = Math.max(maxTime, dist[i]);
            }
        }
        return cnt + " " + maxTime;
    }
   
}