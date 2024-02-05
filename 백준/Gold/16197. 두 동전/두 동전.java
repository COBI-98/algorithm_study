import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int result = Integer.MAX_VALUE;
    static int N;
    static int M;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited1;
    static boolean[][] visited2;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited1 = new boolean[N][M];
        visited2 = new boolean[N][M];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '.') {
                    board[i][j] = 0;
                } else if (str.charAt(j) == '#') {
                    board[i][j] = 2;
                } else if (str.charAt(j) == 'o') {
                    queue.add(new Node(i, j, 0));
                    board[i][j] = 1;
                }
            }
        }

       while (!queue.isEmpty()) {
            Node cur1 = queue.poll();
            Node cur2 = queue.poll();

            if (cur1.x == cur2.x && cur1.y == cur2.y) {
                continue;
            }

            if (result < cur1.cnt || result < cur2.cnt){
                continue;
            }

            if (cur1.cnt > 10 || cur2.cnt > 10) {
                result = -1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = cur1.x + dx[i];
                int ny1 = cur1.y + dy[i];
                int nx2 = cur2.x + dx[i];
                int ny2 = cur2.y + dy[i];

                if (isRange(nx1, ny1) && isRange(nx2, ny2)) {
                    if (board[nx1][ny1] != 2) {
                        queue.add(new Node(nx1, ny1, cur1.cnt + 1));
                    } else {
                        queue.add(new Node(cur1.x, cur1.y, cur1.cnt + 1));
                    }
                    if (board[nx2][ny2] != 2) {
                        queue.add(new Node(nx2, ny2, cur2.cnt + 1));
                    } else {
                        queue.add(new Node(cur2.x, cur2.y, cur2.cnt + 1));
                    }
                } else if (!isRange(nx1, ny1) && isRange(nx2, ny2)) {
                    cur1.cnt++;
                    result = Math.min(result, cur1.cnt);
                } else if (isRange(nx1, ny1) && !isRange(nx2, ny2)) {
                    cur2.cnt++;
                    result = Math.min(result, cur2.cnt);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
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