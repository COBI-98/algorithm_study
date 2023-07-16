import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static char arr[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visit = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        int result = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 'L') {
                    visit = new boolean[N][M];
                    int val = bfs(i,j);
                    result = Math.max(result, val);

                }
            }
        }

        System.out.println(result);

    }
    private static int bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        int val = 0;
        
        visit[i][j] = true;
        queue.add(new Node(j,i,0));
        while(!queue.isEmpty()) {
            Node p = queue.poll();
            for(int d=0; d<4; d++) {
                int newX = p.x + dy[d];
                int newY = p.y + dx[d];
                if(0<=newX && newX<M && 0<=newY && newY<N && !visit[newY][newX] && arr[newY][newX]=='L') {
                    visit[newY][newX] = true;
                    queue.add(new Node(newX, newY, p.cnt+1));
                    val = Math.max(val, p.cnt+1);
                }
            }
        }
        return val;
    }
    
    static class Node{
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