import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int min_value = Integer.MAX_VALUE;

    static int [][] list ;
    static boolean [] visited;
    static int result;

    static class Bacon{
        int idx;
        int value;
        public Bacon(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A][B] = list[B][A] = 1;
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }

        System.out.println(result);
    }

    static void bfs(int idx){
        Queue<Bacon> q = new LinkedList<>();
        
        visited[idx] = true;
        q.offer(new Bacon(idx,0));

        int count = 0;
        while (!q.isEmpty()){
            Bacon bacon = q.poll();
            count += bacon.value;

            for (int i = 1; i <= N; i++) {
                
                if (list[bacon.idx][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(new Bacon(i,bacon.value+1));
                }
                
            }
        }

        if (min_value > count){
            min_value = count;
            result = idx;
        }
    }
}
