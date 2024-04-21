import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int L;
    static Animal[] animals;
    static int range[];
    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        printResult();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        range = new int[M];
        animals = new Animal[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            animals[i] = new Animal(a, b);
        }
    }

    private static void solve() {
        Arrays.sort(range);

        for (int i = 0; i < N; i++) {
            if(animals[i].c > L) continue;
            answer += search(i);
        }
    }

    private static int search(int idx) {

        int start = 0, end = M - 1, mid = 0;
        int min = animals[idx].r + animals[idx].c - L;
        int max = animals[idx].r - animals[idx].c + L;

        while (start <= end) {
            mid = (start + end) / 2;

            if(min <= range[mid] && range[mid] <= max) return 1;
            else if(range[mid] < max) start = mid + 1;
            else end = mid - 1;
        }

        return 0;
    }

    private static void printResult() {
        System.out.println(answer);
    }

    static class Animal {
        int r, c;

        public Animal(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}