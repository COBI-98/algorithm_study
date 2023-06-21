import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int [][] map;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int min ;
    static List<Node> cctv ;

    public static int[][][] mode = {{{0}},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        cctv = new ArrayList<>();
        int zero_cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                }else if(map[i][j] == 0){
                    zero_cnt++;
                }
            }
        }

        min = zero_cnt;
        combination(0, cctv.size(), map);
        System.out.println(min);

    }
    public static void combination(int depth, int r, int[][] map) {
        if(depth == r) {
            int cnt = check(map);
            min = Math.min(min, cnt);
            return;
        }

        int cctv_type = cctv.get(depth).type;
        int x = cctv.get(depth).x;
        int y = cctv.get(depth).y;


        for(int i=0;i<mode[cctv_type].length;i++) {
            int[][] map_copy = new int[N][M];
            for(int k=0;k<N;k++) {
                map_copy[k] = map[k].clone();
            }

            for(int j=0;j<mode[cctv_type][i].length;j++){
                int dir = mode[cctv_type][i][j];

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                while (true) {
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        break;
                    }

                    if(map[nx][ny] == 6) {
                        break;
                    }

                    map_copy[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }


            combination(depth+1, r, map_copy);
        }
    }

    public static int check(int[][] map) {
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Node{
        int x;
        int y;
        int type;
        public Node(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

}
