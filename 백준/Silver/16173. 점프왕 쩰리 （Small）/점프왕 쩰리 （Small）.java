import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int [][] miro;
    public static boolean [][] visited;
    public static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        miro = new int [104][104];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                miro[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        dfs(0,0,miro[0][0]);

        if (!check){
            System.out.println("Hing");
        }else{
            System.out.println("HaruHaru");
        }


    }

    public static void dfs(int x, int y, int jump){

        if (x<0 || y < 0 || x>=N || y>=N || visited[x][y]){
            return;
        }

        visited[x][y] = true;

        if (jump == -1){
            check = true;
            return;
        }
        
        dfs(x,y+jump,miro[x][y+jump]);
        dfs(x+jump,y,miro[x+jump][y]);


    }
}
