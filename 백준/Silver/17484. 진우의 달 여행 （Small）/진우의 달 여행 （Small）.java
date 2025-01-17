import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
    static int answer = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                answer = Math.min(answer, bfs(0, j, k));
            }
        }
        System.out.println(answer);
    }

    static int[][] d = {{1, -1}, {1, 0}, {1, 1}};

    static int bfs(int x, int y, int k) {
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(x, y, graph[x][y], k));
        
        while (!dq.isEmpty()) {
            Node cur = dq.removeFirst();
            for (int i = 0; i < 3; i++) {
                if (i == cur.k) {
                    continue;
                }
                int nx = cur.x + d[i][0];
                int ny = cur.y + d[i][1];
                if (ny < 0 || ny >= M || nx < 0) {
                    continue;
                }
                if (nx == N) {
                    answer = Math.min(answer, cur.value);
                    continue;
                }
                dq.add(new Node(nx, ny, cur.value + graph[nx][ny], i));
            }
        }
        return answer;
    }

    static class Node {
        int x;
        int y;
        int value;
        int k;

        Node(int x, int y, int value, int k) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.k = k;
        }
    }
}