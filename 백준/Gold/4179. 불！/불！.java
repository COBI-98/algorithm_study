import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int R, C, res;
    static char map[][];
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
    static Queue<State> fire, jh;
    static class State {
        int x, y, d;
 
        public State(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }
        
    }
    
    private static boolean bfs() {
        
        while(!jh.isEmpty()) {
            
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                State now = fire.poll();
                
                for (int d = 0; d < 4; d++) {
                    int xx = now.x + dx[d];
                    int yy = now.y + dy[d];
                    
                    if(xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
                    if(map[xx][yy] == '#' || map[xx][yy] == 'F') continue;
                    
                    map[xx][yy] = 'F';
                    fire.add(new State(xx, yy, now.d + 1));
                }    
            }    
            
            size = jh.size();
            for (int i = 0; i < size; i++) {
                State now = jh.poll();
                
                for (int d = 0; d < 4; d++) {
                    int xx = now.x + dx[d];
                    int yy = now.y + dy[d];
                    
                    if(xx < 0 || yy < 0 || xx >= R || yy >= C) {
                        res = now.d + 1;
                        return true;
                    }
                    
                    if(map[xx][yy] == '#' || map[xx][yy] == 'F' || map[xx][yy] == 'J') continue;
                    
                    map[xx][yy] = 'J';
                    jh.add(new State(xx, yy, now.d + 1));
                }    
            }
        }
 
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        fire = new LinkedList<>();
        jh = new LinkedList<>();
        
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 'J') {
                    jh.add(new State(i, j, 0));
                }
                else if(map[i][j] == 'F') {
                    fire.add(new State(i, j, 0));
                }
            }
        }
        
        if(bfs()) System.out.println(res);
        else System.out.println("IMPOSSIBLE");
    }
}
