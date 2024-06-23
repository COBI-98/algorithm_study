import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int grid[][];
    static int dx[] = {-1, 1, -2, 2, -1, 1};
    static int dy[] = {-2, -2, 0, 0, 2, 2};
    static boolean visited[][];
    static Pos end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        grid = new int[size][size];
        visited = new boolean[size][size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Pos start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bfs(start);

    }

    public static void bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid.length && !visited[nextY][nextX]) {
                    if (nextX == end.x && nextY == end.y) {
                        System.out.println(grid[cur.y][cur.x] + 1);
                        return;
                    }
                    visited[nextY][nextX] = true;
                    queue.add(new Pos(nextY, nextX));
                    grid[nextY][nextX] = grid[cur.y][cur.x] + 1;
                }
            }
        }
        System.out.println("-1");
    }

    public static class Pos {
        int x;
        int y;

        public Pos(int y, int x) {
        this.x = x;
        this.y = y;
        }
    }
}

