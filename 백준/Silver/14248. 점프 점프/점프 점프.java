import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int check[];
    static int stoneBridge[];
    static int dir[] = {1, -1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stoneBridge = new int[n];
        check = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stoneBridge[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        System.out.println(bfs(s - 1));

    }

    public static int bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(cur);
        check[cur] = 1;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            int jump = stoneBridge[cur];
            for (int d : dir) {
                int direction = (d * jump) + cur;
                if (direction >= 0 && direction < n && check[direction] == 0) {
                    check[direction] = 1;
                    queue.offer(direction);
                    count++;
                }
            }
        }
        return count;
    }
}