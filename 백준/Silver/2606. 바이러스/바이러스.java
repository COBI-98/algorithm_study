import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int vertex;
    public static int trunk;
    public static int[][] map;
    public static boolean[] visit;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vertex = Integer.parseInt(br.readLine());
        trunk = Integer.parseInt(br.readLine());

        map = new int[vertex+1][vertex+1];
        visit = new boolean[vertex+1];

        for (int i = 0; i < trunk; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start){
        if(visit[start]) {
            return;
        }
        visit[start] = true;
        for (int i = 1; i <= vertex; i++) {
            if (!visit[i] && map[start][i] == 1){
                count = count+1;
                dfs(i);
            }
        }
    }
}
