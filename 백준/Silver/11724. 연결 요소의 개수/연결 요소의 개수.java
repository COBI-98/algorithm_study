import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int vertex;
    public static int trunk;
    public static int [][] graph;
    public static boolean [] visit;
    public static int count;

    public static Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        trunk = Integer.parseInt(st.nextToken());

        graph = new int[vertex+1][vertex+1];
        visit = new boolean[vertex+1];
        for (int i = 0; i < trunk; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A][B] = graph[B][A] = 1;
        }

        count = 0 ;

        for (int i = 1; i <= vertex; i++) {
            if (!visit[i]){
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void bfs(int node){
        visit[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 1; i <= vertex; i++) {
                if(!visit[i] && graph[cur][i] == 1) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
}
