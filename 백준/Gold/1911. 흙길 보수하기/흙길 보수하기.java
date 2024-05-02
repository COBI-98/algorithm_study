import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Node> list = new ArrayList<>();
        int result = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            int nx = cur.x;
            int ny = cur.y;
            
            for (int j = nx; j < ny; j++) {
                if (now < j) {
                    result++;
                    now = j + l - 1;
                }
            }
        }
        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.y;

        }
    }
}