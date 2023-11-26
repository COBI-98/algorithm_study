import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] landInfo;
    static int cnt;
    static Set<Integer> set;

    public int solution(int[][] land) {
        int answer = 0;

        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        landInfo = land;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (landInfo[i][j] == 1 && !visited[i][j]) {
                    set = new HashSet<>();
                    cnt = 1;

                    set.add(j);
                    bfs(i, j);

                    List<Integer> list = new ArrayList<>(set);

                    for (int k = 0; k < list.size(); k++) {
                        Integer curY = list.get(k);
                        map.put(curY, map.get(curY) + cnt);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            max = Math.max(max, map.get(i));
        }
        answer = max;

        return answer;
    }

    private static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny] && landInfo[nx][ny] == 1) {
                    set.add(ny);
                    visited[nx][ny] = true;
                    cnt++;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
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
