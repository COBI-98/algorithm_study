import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    
    static int N, M;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        graph = new List[N * M + 1];
        int[] visited = new int[N * M + 1];
        for (int i = 1; i <= (N * M); i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                add(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        queue.offer(1);
        visited[1]++;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n == N * M) {
                System.out.println(visited[n] - 1);
                return;
            }
            int size = graph[n].size();
            for (int j = 0; j < size; j++) {
                int next = graph[n].get(j);
                if (visited[next] != 0) {
                    continue;
                }
                visited[next] = visited[n] + 1;
                queue.offer(next);
            }
        }
    }
    
    static int calc(int x, int y) {
        return (x - 1) * M + y;
    }

    static void add(int x, int y, int d) {
        int nx;
        int ny;
        int no = calc(x, y);
        for (int i = 0; i < 2; i++) {
            nx = x;
            ny = y;
            for (int j = 0; j < d; j++) {
                nx = nx + dx[i];
                ny = ny + dy[i];
                if (outOfMap(nx, ny)) {
                    break;
                }
                graph[no].add(calc(nx, ny));
            }
        }
    }

    static boolean outOfMap(int x, int y) {
        return x < 1 || x > N || y < 1 || y > M;
    }
}