import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    private static final String SUCCESS = "YES";
    private static final String FAIL = "NO";
    static String answer;
    static int[] parent;
    static int[][] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> trip = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        city = new int[N + 1][N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            trip.add(Integer.parseInt(st.nextToken()));
        }

        int check = find(trip.get(0));

        answer = SUCCESS;

        for (int i = 1; i < M; i++) {
            if (find(trip.get(i)) != check) {
                answer = FAIL;
                break;
            }
        }
        System.out.println(answer);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[x] = y;
        }
    }
}