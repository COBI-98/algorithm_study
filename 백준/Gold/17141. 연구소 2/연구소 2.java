import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int map[][];
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node>virus = new ArrayList<>();
    static boolean visited[][];
    static int copy_map[][]; 
    static boolean virus_visited[]; 
    static int virus_arr[];     
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int max=-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t  = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);

        copy_map = new int[n][n];
        map = new int[n][n];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==2) {
                    virus.add(new Node(i,j,0)); 
                }
            }
        }
        virus_visited = new boolean[virus.size()];
        virus_arr = new int[m];
        dfs(0,0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }
    public static void dfs(int level, int start) {
        if(level==m) {
            bfs();
            return ;
        }
        for(int i=start; i<virus.size(); i++) {
            if(!virus_visited[i]) {
                virus_arr[level]=i;
                virus_visited[i] = true;
                dfs(level+1,i+1);
                virus_visited[i] = false;
            }
        }
    }
    public static void copy() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==2) {
                    copy_map[i][j]=0;
                }
                else {
                    copy_map[i][j]= map[i][j];
                }
            }
        }
    }
    public static boolean isPossible() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(copy_map[i][j]==0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void bfs() {
        max =-1;
        copy();
        visited = new boolean[n][n];
        Queue<Node> q=  new LinkedList<>();
        for(int i=0; i<m; i++) {
            q.add(virus.get(virus_arr[i]));
            int x = virus.get(virus_arr[i]).x;
            int y = virus.get(virus_arr[i]).y;
            copy_map[x][y]=2;
        }
        
        while(!q.isEmpty()) {
            Node a= q.poll();
            max = Math.max(max, a.time);
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(!visited[nx][ny] && copy_map[nx][ny]==0) {
                        visited[nx][ny]=true;
                        copy_map[nx][ny]=2;
                        q.add(new Node(nx,ny,a.time+1));
                    }
                }
            }
        }
        if(isPossible()) {
            min = Math.min(min,max);
        }
    }
}
class Node{
    int x,y,time;
    Node(int x, int y, int time){
        this.x=x;
        this.y=y;
        this.time =time;
    }
}