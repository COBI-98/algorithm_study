import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static int cnt = 0;
    public static ArrayList<Long> arrList = new ArrayList<Long>();

    public static void main(String[] args) throws IOException {
        init();
        solve(0, 0);
        printResult();
    }
    
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());


    }

    public static void solve(int level, long num) {
        if (arrList.contains(num) == false) {
            arrList.add(num);
        }
        if (level >= 10) {
            Collections.sort(arrList);
            return;
        }

        solve(level + 1, (num * 10) + arr[level]);
        solve(level + 1, (num));
    }
    
    private static void printResult() {
        if (N <= 1023) {
            System.out.println(arrList.get(N - 1));
            return;
        }

        System.out.println("-1");
    }
}