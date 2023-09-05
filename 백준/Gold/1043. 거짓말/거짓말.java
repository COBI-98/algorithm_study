import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueKnowNum = Integer.parseInt(st.nextToken());

        if (trueKnowNum == 0) {
            System.out.println(M);
            return;
        }

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        boolean[] knowTrueArr = new boolean[N + 1];
        for (int i = 0; i < trueKnowNum; i++) {
            int people = Integer.parseInt(st.nextToken());
            knowTrueArr[people] = true;
        }

        List<Integer>[] parties = new List[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int peopleNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peopleNum; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));

                if (j != 0) {
                    int now = parties[i].get(j);
                    int pre = parties[i].get(j - 1);

                    union(pre, now);
                }
            }
        }

        boolean[] check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!check[i] && knowTrueArr[i]) {
                int parent = find(i);

                for (int j = 1; j <= N; j++) {
                    if (find(j) == parent) {
                        knowTrueArr[j] = true;
                        check[j] = true;
                    }
                }
            }
        }

        boolean isPossible = true;
        int answer = 0;
        // 진실을 아는 사람이 있다면 false
        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (parties[i].contains(j) && knowTrueArr[j]) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                answer++;
            }
            isPossible = true;
        }

        System.out.println(answer);

    }

    private static void union(int pre, int now) {
        parents[find(now)] = find(pre);
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}
