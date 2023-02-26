import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int [] dx = {1,0,-1,0};
    public static int [] dy = {0,1,0,-1};
    public static int [][] area;
    public static int [][] copyArea;
    public static boolean [][] visit;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        copyArea = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                String color = String.valueOf(st.charAt(j));
                if(color.equals("R")){
                    area[i][j] = 1;
                    copyArea[i][j] = 1;
                }else if(color.equals("B")){
                    area[i][j] = 2;
                    copyArea[i][j] = 2;
                }else{
                    area[i][j] = 3;
                    copyArea[i][j] = 1;
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && area[i][j] == 1){
                    bfs(i,j,1);
                    count++;
                }else if(!visit[i][j] && area[i][j] == 2){
                    bfs(i,j,2);
                    count++;
                }else if(!visit[i][j] && area[i][j] == 3){
                    bfs(i,j,3);
                    count++;
                }
            }
        }

        System.out.print(count);
        System.out.print(" ");

        count = 0;
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && copyArea[i][j] == 1){
                    bfs2(i,j,1);
                    count++;
                }else if(!visit[i][j] && copyArea[i][j] == 2){
                    bfs2(i,j,2);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void bfs(int x, int y, int check){

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(!visit[nx][ny] && area[nx][ny] == 1 && check == 1){
                    bfs(nx,ny,1);
                }else if(!visit[nx][ny] && area[nx][ny] == 2 && check == 2){
                    bfs(nx,ny,2);
                }else if(!visit[nx][ny] && area[nx][ny] == 3 && check == 3){
                    bfs(nx,ny,3);
                }
            }
        }

    }

    public static void bfs2(int x, int y, int check){

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(!visit[nx][ny] && copyArea[nx][ny] == 1 && check == 1){
                    bfs2(nx,ny,1);
                }else if(!visit[nx][ny] && copyArea[nx][ny] == 2 && check == 2){
                    bfs2(nx,ny,2);
                }
            }
        }

    }

}
