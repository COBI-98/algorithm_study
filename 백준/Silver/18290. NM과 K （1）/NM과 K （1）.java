import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    
    static int n;
    static int m;
    static int k;
    static boolean visit[][];
    static int map[][];
    static int result = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sol(0,0,0,k,0);
        System.out.println(result);
    }
    
    public static void sol(int row, int col, int depth, int end, int sum){
        if(depth == end){
            result = Math.max(result, sum);
            return;
        }
        for(int i = row; i < n; i++){
            for(int j = col; j < m; j++){
                if(!visit[i][j]){
                    if(check(i, j)){
                        visit[i][j] = true;
                        sol(0, 0, depth+1, end, sum + map[i][j]);
                        visit[i][j] = false;
                    }
                }
            }
        }
    }
    
    public static boolean check(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                if(visit[nx][ny]) return false;
            }
        }
        return true;
    }
}