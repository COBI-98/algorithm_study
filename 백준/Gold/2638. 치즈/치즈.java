import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] cheeseMap;
    static int answer;
    static List<Node> nodeList = new ArrayList<>();
    static boolean[][] visited;
    static boolean[][] cheeseVisited;
    static boolean[][] placeCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int total = 0;
        cheeseMap = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeseMap[i][j] = Integer.parseInt(st.nextToken());
                if (cheeseMap[i][j] == 1){
                    total++;
                }
            }
        }

        while(total > 0){
            nodeList.clear();
            cheeseVisited = new boolean[N][M];
            visited = new boolean[N][M];
            placeCheck = new boolean[N][M];
            checkInteriorSpace();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cheeseMap[i][j] == 1 && !cheeseVisited[i][j]) {
                        cheeseVisited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }

            for (int i = 0; i < nodeList.size(); i++) {
                Node cur = nodeList.get(i);
                cheeseMap[cur.x][cur.y] = 0;
            }
            total -= nodeList.size();

            answer++;
        }
        System.out.println(answer);
    }

    private static void checkInteriorSpace() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && cheeseMap[nx][ny] == 0){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeseMap[i][j] == 0 && !visited[i][j]) {
                    placeCheck[i][j] = true;
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx,ny) && !placeCheck[nx][ny]){ // 안에있는게 아니고
                if (cheeseMap[nx][ny] == 0){
                    count++;
                }
            }
        }

        if (count >= 2){
            nodeList.add(new Node(x,y));
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isRange(nx, ny) && !cheeseVisited[nx][ny]){
                    if (cheeseMap[nx][ny] == 1 || placeCheck[nx][ny]){
                        cheeseVisited[nx][ny] = true;
                        dfs(nx, ny);
                    }
                }
            }
        }
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < M;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
