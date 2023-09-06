import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int result = Integer.MAX_VALUE;
    static int COUNT = 0;
    static int[] pickNum;
    static boolean[] pickVisit;
    static int[][] map, visit, table;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static Node armyUnit;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) { // 부대
                    armyUnit = new Node(i, j);
                    map[i][j] = 0;
                } else if (map[i][j] == 0) { // 탈영병
                    list.add(new Node(i, j));
                }
            }
        }

        list.add(new Node(armyUnit.x, armyUnit.y));

        pickNum = new int[list.size() + 1];
        pickVisit = new boolean[list.size() + 1];

        pickNum[0] = pickNum[list.size()] = list.size() - 1;
        table = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                table[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int temp = dijkstra(list.get(i), list.get(j));
                if (table[i][j] > temp) {
                    table[i][j] = table[j][i] = temp;
                }
            }
        }

        backTracking(1); // pick 순서별 완탐

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }

    private static int dijkstra(Node start, Node dest) {
        pq.clear();
        pq.add(new Node(start.x, start.y, 0));
        COUNT++;

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (n.x == dest.x && n.y == dest.y) {
                return n.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && visit[nx][ny] != COUNT) {
                    visit[nx][ny] = COUNT;
                    pq.add(new Node(nx, ny, n.dist + map[nx][ny]));
                }
            }
        }
        return -1;
    }

    private static void backTracking(int depth) {
        if (depth == list.size()) {
            int allSum = 0;
            for (int i = 1; i < pickNum.length; i++) {
                allSum += table[pickNum[i - 1]][pickNum[i]];
                if (allSum > result) return; // 가지치기
            }
            result = Math.min(result, allSum);
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (!pickVisit[i]) {
                pickVisit[i] = true;
                pickNum[depth] = i;
                backTracking(depth + 1);
                pickVisit[i] = false;
            }
        }
    }


    private static class Node implements Comparable<Node> {
        int x, y, dist;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}

