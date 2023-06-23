import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char[][] filed;
    static boolean visited[][];
    static int result = 0;
    static int count = 0 ;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Node> arr ;

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        filed = new char[12][6];


        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                filed[i][j] = str.charAt(j);
            }
        }

        boolean puyoCheck;

        while (true) {
            puyoCheck = false;
            arr = new ArrayList<>();
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (filed[i][j] != '.' && !visited[i][j]) {
                        count = 1;
                        visited[i][j] = true;
                        arr.add(new Node(i,j));
                        dfs(i, j, filed[i][j]);
                        visited[i][j] = false;

                        if (count >= 4){
                            for (int k = 0; k < arr.size(); k++) {
                                Node cur = arr.get(k);
                                filed[cur.x][cur.y] = '.';
                            }
                            puyoCheck = true;
                        }

                        arr.clear();

                    }
                }
            }



            // 연쇄 x
            if(!puyoCheck){
                break;
            }
            
            // 연쇄++
            result++;
            
            // 내려가기
            for (int i = 10; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (filed[i][j] != '.' && filed[i+1][j] == '.'){
                        for (int k = i+1; k < 12; k++) {

                            if (filed[k][j] != '.'){
                                break;
                            }
                            filed[k][j] = filed[k-1][j];
                            filed[k-1][j] = '.';
                        }
                    }
                }
            }

        }

        System.out.println(result);

    }

    public static void dfs(int x, int y, char color) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 12 || ny >= 6 || nx<0 || ny <0){
                continue;
            }

            if (filed[nx][ny] == color && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,color);
                visited[nx][ny] = false;
                arr.add(new Node(nx,ny));
                count++;
            }
        }
    }
}
