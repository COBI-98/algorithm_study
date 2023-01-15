import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    public static int vertex;
    public static int trunk;
    public static int start;

    public static int map[][] ;
    public static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        trunk = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        map = new int[vertex+1][vertex+1];
        visit = new boolean[vertex+1];

        for (int i = 0; i < trunk; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(start);
        sb.append('\n');
        visit = new boolean[vertex+1];
        bfs(start);

        System.out.println(sb);
    }

//    public static void dfs(int start) {
//
//        visit[start] = true;
//        sb.append(start + " ");
//
//        for(int i = 0 ; i <= vertex ; i++) {
//            if(map[start][i] == 1 && !visit[i])
//                dfs(i);
//        }
//    }
    public static void dfs(int start) {
        visit[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= vertex ; i++) {
            if(map[start][i] == 1 && !visit[i])
                dfs(i);
        }
    }

    public static void bfs(int start) {
        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= vertex ; i++) {
                if(map[start][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }


    }
}
