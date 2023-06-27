import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int N;
    static int M;
    static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
    static char [][] map;
    static Queue<RedNode> Rqueue ;
    static Queue<BlueNode> Bqueue ;
    static Queue<String> ansQueue;
    static int result = -1;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        Rqueue = new LinkedList<>();
        Bqueue = new LinkedList<>();
        ansQueue = new LinkedList<>();

        for(int i=0; i< N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'R'){
                    Rqueue.offer(new RedNode(i,j));
                    ansQueue.offer("");
                }

                if(map[i][j] == 'B'){
                    Bqueue.offer(new BlueNode(i,j));
                }
            }
        }

        bfs();
        sb.append(result + "\n");
        if (result != -1){
            sb.append(answer);
        }

        System.out.println(sb);

    }

    public static void bfs(){
        boolean check = false;

        while(!Rqueue.isEmpty()){
            RedNode r_cur = Rqueue.poll();
            BlueNode b_cur = Bqueue.poll();
            String dirString = ansQueue.poll();
            int r_nextX ;
            int r_nextY ;
            int b_nextX ;
            int b_nextY ;
            for(int i=0; i<4;i++){
                answer = dirString;
                r_nextX = r_cur.x;
                r_nextY = r_cur.y;
                b_nextX = b_cur.x;
                b_nextY = b_cur.y;

                if(i==0) answer+="U";
                else if(i==1) answer+="D";
                else if(i==2) answer+="L";
                else answer+="R";

                check = false;

                if(answer.length() > 10){ // 10번 조건
                    break;
                }

                while (true) {  //빨간 구슬
                    r_nextX += dx[i];
                    r_nextY += dy[i];

                    if (r_nextX>=N || r_nextY >=M || r_nextX<0 || r_nextY < 0){
                        break;
                    }

                    if (map[r_nextX][r_nextY] == '#') {
                        break;
                    }
                    if (map[r_nextX][r_nextY] == 'O') {
                        check = true;
                        break;
                    }
                }

                while (true) { // 파란구슬
                    b_nextX += dx[i];
                    b_nextY += dy[i];

                    if (b_nextX>=N || b_nextY >=M || b_nextX<0 || b_nextY < 0){
                        break;
                    }

                    if (map[b_nextX][b_nextY] == 'O') {
                        result = -1;
                        break;
                    }
                    if (map[b_nextX][b_nextY] == '#') {
                        if (r_nextX == b_nextX && r_nextY == b_nextY) { // 빨간 구슬과 파란 구슬 좌표가 같으면 위치 조정
                            if (i == 0) {
                                if (b_cur.x < r_cur.x) {
                                    b_nextX -= dx[i];
                                    r_nextX = b_nextX - dx[i];
                                } else {
                                    r_nextX -= dx[i];
                                    b_nextX = r_nextX - dx[i];
                                }
                            } else if (i == 1) {
                                if (b_cur.x < r_cur.x) {
                                    r_nextX -= dx[i];
                                    b_nextX = r_nextX - dx[i];
                                } else {
                                    b_nextX -= dx[i];
                                    r_nextX = b_nextX - dx[i];
                                }
                            } else if (i == 2) {
                                if (b_cur.y < r_cur.y) {
                                    b_nextY -= dy[i];
                                    r_nextY = b_nextY - dy[i];
                                } else {
                                    r_nextY -= dy[i];
                                    b_nextY = r_nextY - dy[i];
                                }
                            } else {
                                if (b_cur.y < r_cur.y) {
                                    r_nextY -= dy[i];
                                    b_nextY = r_nextY - dy[i];
                                } else {
                                    b_nextY -= dy[i];
                                    r_nextY = b_nextY - dy[i];
                                }
                            }
                        } else {
                            r_nextX -= dx[i];
                            r_nextY -= dy[i];
                            b_nextX -= dx[i];
                            b_nextY -= dy[i];
                            if (check) { // 최소 횟수
                                result = answer.length();
                                break;
                            }
                        }
                        if (!(r_cur.x == r_nextX && r_cur.y == r_nextY && b_cur.x == b_nextX && b_cur.y == b_nextY)) { // 원래 위치와 동일하지 않으면
                            Rqueue.add(new RedNode(r_nextX, r_nextY));
                            Bqueue.add(new BlueNode(b_nextX, b_nextY));
                            ansQueue.add(answer);
                        }
                        break;
                    }
                }
                if (result>0) break;
            }
            if (result>0) break;
        }

    }

    static class RedNode{
        int x;
        int y;
        public RedNode(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class BlueNode{
        int x;
        int y;
        public BlueNode(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}