import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {
    
    static final int INF = 1_000_000_000;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        boolean[][] isWall = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++)
                isWall[i][j] = row.charAt(j) - '0' == 1;
        }
        
        Pair[] pairs = new Pair[3];
        
        for (int i = 0; i < 3; i++) {
            line = br.readLine().split(" ");
            int y = Integer.parseInt(line[0]) - 1;
            int x = Integer.parseInt(line[1]) - 1;
            pairs[i] = new Pair(y, x);
        }
        
        Deque<Node> deque = new ArrayDeque<>();
        int[][][] minDistance = new int[3][r][c];
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < r; j++)
                for (int k = 0; k < c; k++)
                    minDistance[i][j][k] = INF;
        
        for (int i = 0; i < 3; i++) {
            Pair start = pairs[i];
            boolean[][] isVisited = new boolean[r][c];
            isVisited[start.y][start.x] = true;
            deque.offerLast(new Node(0, start));
            while (!deque.isEmpty()) {
                Node node = deque.pollFirst();
                int lv = node.lv;
                int y = node.pair.y;
                int x = node.pair.x;
                minDistance[i][y][x] = lv;
                for (int j = 0; j < 4; j++) {
                    int newY = y + dy[j];
                    int newX = x + dx[j];
                    if (newY >= 0 && newY < r && newX >= 0 && newX < c &&
                            !isVisited[newY][newX] && !isWall[newY][newX]) {
                        isVisited[newY][newX] = true;
                        deque.offerLast(new Node(lv + 1, new Pair(newY, newX)));
                    }
                }
            }
        }
        
        int min = INF;
        int count = 0;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                int max = Collections.max(
                        List.of(minDistance[0][i][j], minDistance[1][i][j], minDistance[2][i][j]));
                if (max == INF)
                    continue;
                if (min == max)
                    count++;
                else if (min > max) {
                    min = max;
                    count = 1;
                }
            }
        if (min == INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
        System.out.println(count);
    }
    
    static class Pair {
        public int y;
        public int x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static class Node {
        public int lv;
        public Pair pair;
        public Node(int lv, Pair pair) {
            this.lv = lv;
            this.pair = pair;
        }
    }
}