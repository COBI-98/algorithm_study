import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Virus> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        PriorityQueue<Virus> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num != 0) {
                    pq.offer(new Virus(i, j, num));
                }
            }
        }

        while (!pq.isEmpty()) {
            Virus v = pq.poll();
            q.offer(v);
        }

        st = new StringTokenizer(br.readLine());
        int endTime = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endX = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < endTime; i++) {
            Queue<Virus> q2 = new LinkedList<>();

            while (!q.isEmpty()) {
                Virus v = q.poll();
                q2.offer(v);
            }

            while (!q2.isEmpty()) {
                Virus v = q2.poll();

                solve(v);
            }
        }

        System.out.println(map[endY][endX]);
    }

    public static void solve(Virus v) {
        for (int i = 0; i < 4; i++) {
            int tempY = v.y + dy[i];
            int tempX = v.x + dx[i];

            if (tempY < 0 || tempY >= N || tempX < 0 || tempX >= N) {
                continue;
            }

            int vRank = map[tempY][tempX];

            if (vRank == 0) {
                map[tempY][tempX] = v.rank;
                q.offer(new Virus(tempY, tempX, v.rank));
            }
        }
    }

    public static class Virus implements Comparable<Virus> {
        int y;
        int x;
        int rank;

        public Virus(int y, int x, int rank) {
            this.y = y;
            this.x = x;
            this.rank = rank;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.rank < o.rank) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}