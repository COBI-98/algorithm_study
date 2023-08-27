import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int lectures;
    static int preReq;
    static int[] indegree;
    static int[] dp;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        printResult();

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        lectures = Integer.parseInt(st.nextToken());
        preReq = Integer.parseInt(st.nextToken());

        indegree = new int[lectures + 1];
        dp = new int[lectures + 1];

        list = new ArrayList[lectures + 1];

        for (int i = 1; i <= lectures; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= preReq; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[pre].add(next);
            indegree[next]++;

        }
    }

    private static void solve() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= lectures; i++) {
            if (indegree[i] == 0) {
                queue.offer(new int[]{i, 1});
            }
        }

        while (!queue.isEmpty()){
            int[] lecture = queue.poll();
            int idx = lecture[0];
            int semester = lecture[1];

            dp[idx - 1] = semester;

            for (int nextLec: list[idx]){
                indegree[nextLec]--;
                if (indegree[nextLec] == 0){
                    queue.offer(new int[] {nextLec, semester + 1});
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lectures; i++) {
            sb.append(dp[i] + " ");
        }

        System.out.println(sb);
    }

}
