import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int N ;
    public static int count;
    public static int min = Integer.MAX_VALUE;
    public static int team_start ;
    public static int team_link;
    public static int [][] map ;
    public static boolean[] visit;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            count = 0;
            while (st.hasMoreTokens()){
                map[count][i] = Integer.parseInt(st.nextToken());
                count++;
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    public static void dfs(int idx, int count){
        if (count == N /2){

            minimum();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                dfs(i+1,count+1);
                visit[i] = false;
            }

        }
    }

    public static void minimum(){
        team_start = 0 ;
        team_link = 0 ;

        /*
         * 대각선만 확인
         */
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visit[i] == true && visit[j] == true){
                    team_start += map[i][j];
                    team_start += map[j][i];
                }else if(visit[i] ==false && visit[j] == false){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }
        int value = Math.abs(team_start - team_link);

        if(value == 0){
            System.out.println(value);
            System.exit(0);
        }

        min = Math.min(value,min);
    }

}
