import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        init();
        calculateMatrix();
    }
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void calculateMatrix() {
        for (int i = 0; i < 101; i++) {
            try {
                if (arr[r][c] == k) {
                    System.out.println(i);
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // 에러 처리
            }

            if (arr.length >= arr[0].length) {
                calculate();
                continue;
            }
            transpose();
            calculate();
            transpose();

        }

        System.out.println(-1);
    }

    static void transpose() {
        int[][] tmpArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tmpArr[j][i] = arr[i][j];
            }
        }
        arr = tmpArr;
    }

    static void calculate() {
        int mx = 0;
        for (int i = 0; i < arr.length; i++) {
            PriorityQueue<Node> nums = new PriorityQueue<>();
            boolean[] visited = new boolean[101];

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && !visited[arr[i][j]]) {
                    int cnt = count(arr[i], arr[i][j]); 
                    visited[arr[i][j]] = true; 
                    nums.add(new Node(arr[i][j], cnt));
                }
            }

            ArrayList<Integer> tmp = new ArrayList<>();
            while (!nums.isEmpty()) {
                Node cur = nums.poll();
                tmp.add(cur.num);
                tmp.add(cur.cnt);
            }
            changeArrElement(i, tmp);

            mx = Math.max(mx, arr[i].length); 
        }

        addZeroToMatrix(mx);
    }


    static int count(int[] arr, int num) {
        int cnt = 0;
        for (int i : arr) {
            if (i == num) {
                cnt++;
            }
        }
        return cnt;
    }

    static void changeArrElement(int i, ArrayList<Integer> tmp) {
        arr[i] = new int[tmp.size()];
        for (int j = 0; j < tmp.size(); j++) {
            arr[i][j] = tmp.get(j);
        }
    }

    static void addZeroToMatrix(int mx) {
        for (int i = 0; i < arr.length; i++) {
            int length = arr[i].length;
            if (length < mx) {
                int[] tmpArr = new int[mx];

                for (int idx = 0; idx < length; idx++) {
                    tmpArr[idx] = arr[i][idx];
                }

                for (int idx = length; idx < mx; idx++) {
                    tmpArr[idx] = 0;
                }

                arr[i] = tmpArr;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            }
            return this.cnt - o.cnt;
        }
    }
}
