import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static char [][] map;
    static int result = 0;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    

    public static void main(String[] args) throws IOException {
        input();
        rowUpDownSearchWallOfCount();
        colLeftRightSearchWallOfCount();

        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char [N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
    }

    private static void rowUpDownSearchWallOfCount() {
        for(int k = 0; k<2; k++){
            for(int i = 1; i<N-1; i++){
                int count = 0;
                for(int j = 1; j<M-1; j++){

                    if(map[i][j]=='.'){
                        if(map[i+dx[k]][j] == 'X') {
                            count++;
                            continue;
                        }
                    }

                    result += count / 2;
                    count = 0;
                }

                result += count / 2;
            }
        }
    }

    private static void colLeftRightSearchWallOfCount() {
        for(int k = 2; k<4; k++){
            for(int j = 1; j<M-1; j++){
                int count = 0;
                for(int i = 1; i<N-1; i++){

                    if(map[i][j]=='.'){
                        if(map[i][j+dy[k]] == 'X') {
                            count++;
                            continue;
                        }
                    }

                    result += count / 2;
                    count = 0;
                }

                result += count / 2;
            }
        }
    }
    
}