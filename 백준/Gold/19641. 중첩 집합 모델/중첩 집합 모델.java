import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int S;
    static ArrayList<ArrayList<Integer>> edges;
    static int[][] tree;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            while (true) {
                b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                edges.get(a).add(b);
            }
            Collections.sort(edges.get(a));
        }

        S = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];
        getRight(S, 1);

        StringBuilder ab = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            ab.append(i + " " + tree[i][0] + " " + tree[i][1] + "\n");
        }
        System.out.println(ab);
    }

    private static int getRight(int node, int n) {
        tree[node][0] = n;

        ArrayList<Integer> edge = edges.get(node);
        int next;
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);
            if (tree[next][0] != 0) {
                continue;
            }
            n = getRight(next, n + 1);
        }

        tree[node][1] = n + 1;

        return n + 1;
    }
}