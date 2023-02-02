import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static ArrayList<int[]> home = new ArrayList<>();
    public static ArrayList<int[]> chickenHome = new ArrayList<int []>();
    public static boolean [] open ;
    public static int cityChickenMin = Integer.MAX_VALUE; // 도시 치킨거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int A = Integer.parseInt(st.nextToken());
                if (A == 1){
                    home.add(new int[] {i, j});
                }else if (A == 2){
                    chickenHome.add(new int[] {i, j});
                }
            }
        }

        open = new boolean[chickenHome.size()];

        dfs(0,0);

        System.out.println(cityChickenMin);
    }

    public static void dfs(int start, int cnt){
        if (cnt == M){
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int chickenMin = Integer.MAX_VALUE;
                for (int j = 0; j < chickenHome.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(home.get(i)[0] - chickenHome.get(j)[0])
                                + Math.abs(home.get(i)[1] - chickenHome.get(j)[1]);

                        chickenMin = Math.min(chickenMin, distance);
                    }
                }
                res += chickenMin;
            }
            cityChickenMin = Math.min(cityChickenMin, res);
        }

        for (int i = start; i < chickenHome.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

}
