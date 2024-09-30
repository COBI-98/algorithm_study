import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    static int[] count;
    static ArrayList<Integer>[] adjList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        count = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[b].add(a);
        }
        int x = Integer.parseInt(br.readLine());
        solve(x, 0);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void solve(int target, int task) {
        count[target] = task;
        for (Integer next : adjList[target]) {
            if (count[next] == 0) {
                solve(next, task + 1);
            }
        }
    }
}