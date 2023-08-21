import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] colorPaperCrafts;
    static boolean[][] visited;
    static Queue<Node> queue;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        colorPaperCrafts = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                colorPaperCrafts[i][j] = str.charAt(j);
            }
        }

        queue = new LinkedList<>();
    }

    private static void solve() {
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]){
                    queue.add(new Node(i,j));
                    if (!bfs(i,j)){
                        System.out.print("BaboBabo");
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println("dd");
    }

    private static boolean bfs(int x, int y) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(x,y));
        visited[x][y] =true;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isRange(nx,ny)&& !visited[nx][ny]){
                    if (colorPaperCrafts[x][y] == colorPaperCrafts[nx][ny]){
                        queue.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                        list.add(new Node(nx,ny));
                    }
                }
            }
        }

        int ansX = list.get(list.size()-1).x - list.get(0).x + 1;
        int ansY = list.get(list.size()-1).y - list.get(0).y + 1;

        if ((ansX * ansY) == list.size()){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}