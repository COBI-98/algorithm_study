import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    static List<Integer>[] relations;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        relations = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        int moveCnt = bfs(1);
        if (moveCnt % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static int bfs(int startNode) {
        int sum = 0;
        visited[startNode] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startNode, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int reafNode = 0;
            for (int next : relations[now[0]]) {
                if (visited[next]) {
                    continue;
                }
                reafNode++;
                visited[next] = true;
                q.add(new int[]{next, now[1] + 1});
            }
            if (reafNode == 0) {
                sum += now[1];
            }
        }
        return sum;
    }
}