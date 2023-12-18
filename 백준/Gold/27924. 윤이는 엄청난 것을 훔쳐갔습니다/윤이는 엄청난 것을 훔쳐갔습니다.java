import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited, leaf;

    static List<Integer>[] adjList;
    static Queue<Loc> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        leaf = new boolean[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);

        }

        for (int i = 1; i <= n; i++) {
            if (adjList[i].size() == 1) {
                leaf[i] = true;
            }
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();

        queue.add(new Loc(b, false));
        queue.add(new Loc(c, false));
        queue.add(new Loc(a, true));

        visited[a] = true;
        visited[b] = true;
        visited[c] = true;

        System.out.println(bfs() ? "YES" : "NO");

    }

    static boolean bfs() {
        boolean possible = false;
        Loc cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();

            if (leaf[cur.x] && cur.r) {
                possible = true;
                break;
            }

            for (int next : adjList[cur.x]) {
                if (visited[next]){
                    continue;
                }
                visited[next] = true;

                queue.add(new Loc(next, cur.r));

            }
        }
        return possible;
    }

    static class Loc {
        int x;
        boolean r;

        public Loc(int x, boolean r) {
            super();
            this.x = x;
            this.r = r;
        }

    }
}