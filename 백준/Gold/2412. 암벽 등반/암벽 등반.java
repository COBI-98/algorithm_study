import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int T;
    static List<Node>[] adjList;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[T + 1];

        for (int i = 0; i <= T; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjList[y].add(new Node(x, y));
        }
    }

    private static void solve() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.y == T) {
                System.out.println(cur.count);
                return;
            }

            for (int i = -2; i <= 2; i++) {
                int ny = cur.y + i;
                if (ny < 0 || ny > T) {
                    continue;
                }

                for (Node node : adjList[ny]) {
                    if (node.visit || node.x < cur.x - 2 || node.x > cur.x + 2) {
                        continue;
                    }
                    node.visit = true;
                    node.count = cur.count + 1;
                    queue.add(node);
                }
            }
        }
        System.out.println(-1);
    }

    static class Node implements Comparable<Node> {
        int x, y, count;
        boolean visit;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.visit = false;
            this.count = 0;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.y - o.y;
            }
            return this.count - o.count;
        }
    }
}
