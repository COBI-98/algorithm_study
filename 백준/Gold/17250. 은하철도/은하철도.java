import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int[] arr;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
            dist[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            arr[parentB] = parentA;
            dist[parentA] += dist[parentB];
            dist[parentB] = dist[parentA];
        }

        sb.append(dist[parentA] + "\n");
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
    
}