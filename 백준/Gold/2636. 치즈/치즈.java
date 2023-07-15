import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static List<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; 
        int firstCount = getCount(); 

        while (true) {
            time++;

            bfs(new Node(0, 0));

            for (int i = 0; i < N; i++){
                Arrays.fill(visited[i], false); 
            }

            int count = getCount();

            if (count == 0)
                break;
            else
                list.add(count);
        }

        System.out.println(time);

        if (list.size() > 0) 
            System.out.println(list.get(list.size() - 1));
        else 
            System.out.println(firstCount);

    }


    static void bfs(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[node.x][node.y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 1) { 
                            map[nx][ny] = 2;
                            visited[nx][ny] = true;
                        }
                        if (map[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }

        removeCheese(); 
    }

    static void removeCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2)
                    map[i][j] = 0;
            }
        }
    }

    static int getCount() {

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x= x;
            this.y = y;
        }
    }
}
