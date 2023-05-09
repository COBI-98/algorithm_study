import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {

    static int N;
    static char [][] pan;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int [] list = new int [5]; //왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽다리
    static int [] heart = new int[2];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        pan = new char[N][N];
        for(int i=0; i<N;i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                pan[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(pan[i][j] == '*' && heartCheck(i,j)){
                    heart[0] = i;
                    heart[1] = j;
                }
            }
        }
        // 왼팔
        for(int i=0; i<heart[1];i++){
            if(pan[heart[0]][i] == '*'){
                list[0]++;
            }
        }

        // 오른팔
        for(int i=heart[1]+1; i <N; i++){
            if(pan[heart[0]][i] == '*'){
                list[1]++;
            }
        }

        int legY = 0;
        //허리
        for(int i=heart[0]+1; i<N; i++){
            if(pan[i][heart[1]] == '*'){
                list[2]++;
            }else{
                legY = i;
                break;
            }
        }

        int leftlegY = heart[1]-1;
        int rightlegY = heart[1]+1;

        for(int i=legY; i<N;i++){
            if(pan[i][leftlegY] == '*'){
                list[3]++;
            }
        }

        for(int i=legY; i<N;i++){
            if(pan[i][rightlegY] == '*'){
                list[4]++;
            }
        }

        sb.append((heart[0]+1)+" "+(heart[1]+1)+"\n");
        for(int i=0; i<5; i++){
            sb.append(list[i]+" ");
        }

        System.out.println(sb);
    }

    public static boolean heartCheck(int x, int y){
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx<N && ny<N ){
                if(pan[nx][ny] != '*'){
                    return false;
                }
            }
        }

        return true;
    }

}
