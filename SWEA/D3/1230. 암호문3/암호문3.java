import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            List<String> arr = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                String o = st.nextToken();
                if (o.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        arr.add(x + j, st.nextToken());
                    }
                }
                if (o.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        arr.remove(x);
                    }
                }
                if (o.equals("A")) {
                    int x = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < x; j++) {
                        arr.add(st.nextToken());
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            Iterator<String> iterator = arr.iterator();
            for (int i = 0; i < 10; i++) {
                sb.append(iterator.next()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
