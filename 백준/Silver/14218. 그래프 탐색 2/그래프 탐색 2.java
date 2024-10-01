import java.io.*;
import java.util.*;
public class Main {
    
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> roads = new ArrayList<>();
    static int q;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            roads.get(first).add(second);
            roads.get(second).add(first);
        }
        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            roads.get(first).add(second);
            roads.get(second).add(first);
            bfs();
        }
        System.out.println(sb);
    }
    
    static void bfs() {
        int[] min = new int[n+1];
        boolean[] visited = new boolean[n+1];
        visited[0] = true;
        for (int i = 0; i <= n; i++) {
            min[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        min[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : roads.get(cur)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    min[next] = min[cur] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            sb.append(min[i]).append(" ");
        }
        sb.append("\n");
    }
    
}