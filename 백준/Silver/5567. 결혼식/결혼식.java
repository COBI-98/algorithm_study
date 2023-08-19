import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int ans;

    static int[][] friendsGraph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friendsGraph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            friendsGraph[from][to] = 1;
            friendsGraph[to][from] = 1;
        }

        bfs(1);

        System.out.println(ans);
    }

    private static void bfs(int start) {
        Queue<Friend> q = new ArrayDeque<>();
        q.offer(new Friend(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Friend cur = q.poll();
            int fNumb = cur.fNum;
            int depth = cur.depth;
            ;

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && friendsGraph[fNumb][i] == 1) {
                    if (depth + 1 > 2) {
                        return;
                    }
                    visited[i] = true;
                    ans++;
                    q.offer(new Friend(i, depth + 1));
                }
            }
        }
    }

    static class Friend {
        int fNum;
        int depth;

        Friend(int fNum, int depth) {
            this.fNum = fNum;
            this.depth = depth;
        }
    }
    
}