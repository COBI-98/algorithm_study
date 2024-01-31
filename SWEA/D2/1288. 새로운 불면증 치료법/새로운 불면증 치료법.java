import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

    private static final String PRINT_FORMAT = "#%d %d";
    private static boolean[] visited;
    private static int T;
    private static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            visited = new boolean[10];

            result = solve(N);

            sb.append(String.format(PRINT_FORMAT, test_case, result))
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(int N) {
        int count = 1;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(N));
        int flag;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            flag = 0;

            for (int i = 0; i < 10; i++) {

                if (visited[i]) {
                    flag++;
                    continue;
                }

                for (int j = 0; j < cur.arr.length; j++) {
                    if (!visited[i]) {
                        if (i == cur.arr[j]) {
                            flag++;
                            visited[i] = true;
                        }
                    }
                }
            }

            if (flag != 10) {

                count++;
                queue.add(new Node(count * N));
            }
        }

        return count * N;
    }

    static class Node {
        int N;
        int[] arr;

        public Node(int n) {
            N = n;
            arr = createArr(n);
        }

        private int[] createArr(int n) {
            Set<Integer> set = new HashSet<>();

            while (n / 10 >= 1) {
                int mod = n % 10;
                set.add(mod);
                n = n / 10;
            }
            set.add(n % 10);

            arr = new int[set.size()];

            List<Integer> list = new LinkedList<>(set);

            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }
}
