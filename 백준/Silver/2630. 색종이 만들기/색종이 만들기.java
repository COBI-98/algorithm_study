import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[] colorPaper = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);

        System.out.println(colorPaper[0]);
        System.out.println(colorPaper[1]);
    }

    public static void divide(int x, int y, int size){
        if (colorCheck(x,y,size)){
            if (map[x][y] == 0){
                colorPaper[0]++;
            }else {
                colorPaper[1]++;
            }

            return;
        }

        int sizeDivide = size/2;

        divide(x,y,sizeDivide);
        divide(x+sizeDivide,y,sizeDivide);
        divide(x,y+sizeDivide,sizeDivide);
        divide(x+sizeDivide,y+sizeDivide,sizeDivide);
    }

    public static boolean colorCheck(int nx, int ny, int nSize){

        int A = map[nx][ny];

        for (int i = nx; i < nx+nSize; i++) {
            for (int j = ny; j < ny+nSize; j++) {
                if (map[i][j] != A){
                    return false;
                }
            }
        }

        return true;
    }
}
