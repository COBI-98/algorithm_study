import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int M;
    static int INF = Integer.MAX_VALUE;
    static char [][] map;
    static int [][] dist;
    static boolean [][] visited;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int min = Integer.MAX_VALUE;
    static int startX, startY, endX, endY;
    static Queue<Node> queue ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            Arrays.fill(dist[i],INF);
            String str = br.readLine();

            for(int j=0; j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '+'){
                    dist[i][j] = 0;
                    queue.offer(new Node(i,j,0));
                } else if(map[i][j] == 'V'){
                    startX = i;
                    startY = j;
                } else if(map[i][j] == 'J'){
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs();

        System.out.println(dijkstra());
    }
    public static void bfs(){

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int distance;

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                distance = cur.d + 1;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(distance < dist[nx][ny]) {
                    dist[nx][ny] = distance;
                    queue.offer(new Node(nx, ny, distance));
                }
            }
        }
    }

    public static int dijkstra(){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startX, startY, dist[startX][startY]));
        visited[startX][startY] = true;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(min > cur.d) {
                min = cur.d;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if(nx == endX && ny == endY) {
                    return min;
                }

                visited[nx][ny] = true;
                pq.offer(new Node(nx, ny, dist[nx][ny]));
            }
        }

        return 0;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;

        public Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return o.d - this.d;
        }
    }

}
