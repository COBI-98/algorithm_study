import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[3001 + (N * 2)][3001 + (M * 2)];

        for (int i = 0; i < 3001 + (N * 2); i++) {
            Arrays.fill(map[i], '.');
        }


        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int x = 1500 + i;
                int y = 1500 + j;
                map[x][y] = str.charAt(j);
                if (map[x][y] == 'o') {
                    queue.add(new Node(x, y, 0));
                    ans++;
                }
            }
        }

        K = Integer.parseInt(br.readLine());

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.cnt == K) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (map[nx][ny] == '.') {
                    map[nx][ny] = 'o';
                    ans++;
                    queue.add(new Node(nx, ny, cur.cnt + 1));
                }
            }
        }

        System.out.println(ans);
    }


    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
