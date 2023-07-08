import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] time;
    static int[] know;

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        know = new int[N+1];

        ArrayList<Integer>[] list = new ArrayList[N+1];

        for (int i = 0; i<N+1; i++) {
            time[i] = -1;
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= M; i++) {
            int start = Integer.parseInt(st.nextToken());
            queue.add(new Node(start,0));
            time[start] = 0;
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int next : list[cur.x]) {
                know[next]++;

                if (next != 0 && time[next] == -1 && know[next] >= (list[next].size())/2) {
                    queue.add(new Node(next, cur.level+1));
                    time[next] = cur.level+1;
                }
            }
        }

        for (int i=1; i<N+1; i++) {
            sb.append(time[i]+" ");
        }

        System.out.println(sb);
    }

    static class Node {
        int x;
        int level;
        public Node (int x, int level){
            this.x = x;
            this.level = level;
        }
    }
}
