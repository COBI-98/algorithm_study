import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int BOARD_SIZE = 5;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[BOARD_SIZE][BOARD_SIZE];
        visited = new boolean[BOARD_SIZE][BOARD_SIZE][64];
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        q.add(new Node(x, y, 0));
    }

    private static int solve() {
        int minNumberOfMoves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                if (cur.cnt == 63) {
                    return minNumberOfMoves;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (isRangeAndCondition(cur, nx, ny)) {
                        if (board[nx][ny] == 0) {
                            visited[nx][ny][cur.cnt] = true;
                            q.offer(new Node(nx, ny, cur.cnt));
                        } else {
                            int temp = cur.cnt | (1 << (board[nx][ny] - 1));
                            visited[nx][ny][temp] = true;
                            q.offer(new Node(nx, ny, temp));
                        }
                    }
                }
            }
            minNumberOfMoves++;
        }

        return -1;
    }

    private static boolean isRangeAndCondition(Node cur, int nx, int ny) {
        return 0 <= nx && nx < BOARD_SIZE && 0 <= ny && ny < BOARD_SIZE
                && board[nx][ny] != -1 && !visited[nx][ny][cur.cnt];
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