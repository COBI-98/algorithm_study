import java.util.*;
import java.io.*;

public class Main {
    
    static int a, b, c;
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static boolean[] answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[3];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0][0] = true;
        answer[arr[2]] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int a = cur.A;
            int b = cur.B;
            int c = arr[2] - a - b;

            for (int k = 0; k < 6; k++) {
                int[] next = {a, b, c};
                next[receiver[k]] += next[sender[k]];
                next[sender[k]] = 0;

                if (next[receiver[k]] > arr[receiver[k]]) {
                    next[sender[k]] = next[receiver[k]] - arr[receiver[k]];
                    next[receiver[k]] = arr[receiver[k]];
                }

                if (!visited[next[0]][next[1]]) { 
                    visited[next[0]][next[1]] = true;
                    que.add(new Node(next[0], next[1]));

                    if (next[0] == 0) { 
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class Node {
        int A;
        int B;

        public Node(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }
}