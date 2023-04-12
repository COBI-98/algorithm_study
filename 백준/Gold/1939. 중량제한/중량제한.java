import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 4 4
     * 3 1 3
     * 2 3 2
     * 2 4 4
     * 1 4 1  // 2
     */
    public static int N;
    public static int M;
    public static boolean [] visited;

    static class Island {
        int destination;
        int cost;

        Island (int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
    public static ArrayList<ArrayList<Island>> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Island(B,C));
            list.get(B).add(new Island(A,C));

            max = Math.max(max, C);
        }

        right = max;

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(divide(left, right, start, end) - 1);
    }

    private static int divide(int left, int right, int start, int end) {

        while (left <= right) {

            int mid = (left + right)/2;
            visited = new boolean[N+1];

            if (bfs(start,end,mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }

        }
        return left;
    }

    public static boolean bfs(int start, int end, int mid){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){

            int island = q.poll();

            if (island == end){
                return true;
            }

            for (Island i : list.get(island)) {
                if(!visited[i.destination] && mid <= i.cost){
                    visited[i.destination] = true;
                    q.offer(i.destination);
                }
            }

        }

        return false;
    }

}
