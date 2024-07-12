import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int ans, meso, K;
    static Info Boss[];
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Long> damage = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            damage.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(damage, Collections.reverseOrder());

        Boss = new Info[K];
        isSelected = new boolean[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            Boss[i] = new Info(p, q);
        }
        ans = 0;

        for (int i = 0; i < M; i++) {
            long dps = damage.get(i) * 60 * 15;
            meso = 0;
            solve(0, 0, 0, dps);
            ans += meso;
        }
        sb.append(ans);
        System.out.print(sb);
    }

    static void solve(int n, long acc, int cal, long dps) {
        if (acc > dps) {
            return;
        }

        if (n == K) {
            meso = Math.max(meso, cal);
            return;
        }
        for (int i = n; i < K; i++) {
            isSelected[i] = true;
            long nextCal = 0;
            if (Boss[i].hp % (dps / 900) == 0) {
                nextCal = Boss[i].hp;
            } else {
                nextCal = ((Boss[i].hp / (dps / 900)) + 1) * (dps / 900);
            }

            acc += nextCal;
            cal += Boss[i].m;
            solve(i + 1, acc, cal, dps);
            isSelected[i] = false;

            acc -= nextCal;
            cal -= Boss[i].m;
            solve(i + 1, acc, cal, dps);
        }
    }

    static class Info {
        long hp;
        int m;

        public Info(long hp, int m) {
            this.hp = hp;
            this.m = m;
        }
    }
}