import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, answer;
    private  static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 0);
        System.out.println(answer);
    }
    
    public static void dfs(int index, int size, int time) {

        if (index == N || time == M) {
            answer = Math.max(answer, size);
            return;
        }

        dfs(index + 1, size + list[index + 1], time + 1);
        if (index + 2 > N) {
            return;
        }
        dfs(index + 2, size / 2 + list[index + 2], time + 1);
    }
}