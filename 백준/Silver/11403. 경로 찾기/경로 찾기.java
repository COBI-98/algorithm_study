import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;   
    static int[][] map;
    static int[][] dp;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        dp = new int[N][N];
        
        StringTokenizer st ;
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k = 0; k<N; k++){
            for(int i=0;i<N; i++){
                for(int j=0;j<N; j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
        
        
    }
}
