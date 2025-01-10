import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int waitingNum = Integer.parseInt(br.readLine());
        
        if (waitingNum > C * R) {
            System.out.println(0);
        } else {
            boolean[][] assigned = new boolean[C + 1][R + 1];
            int x = 1;
            int y = 0;
            int dir = 0;
            for (int i = 0; i < waitingNum; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 1 || ny < 1 || nx > C || ny > R || assigned[nx][ny]) {
                    i--;
                    dir = (dir + 1) % 4;
                    continue;
                }
                x = nx;
                y = ny;
                assigned[x][y] = true;
            }
            System.out.println(x + " " + y);
        }
    }
}