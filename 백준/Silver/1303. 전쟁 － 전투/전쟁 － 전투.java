import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static String[][] map; 
	static boolean[][] visit; 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		map = new String[m][n];
		visit = new boolean[m][n];
		
		int score1 = 0;
		int score2 = 0;
        
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split("");
			
			for(int j = 0; j < n; j++) {
				map[i][j] = str[j];
			}
		} 
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) { 
					int temp = bfs(i, j); 
					
					if(map[i][j].equals("W")) {
						score1 += temp * temp;
					} else { 
						score2 += temp * temp;
					}
				}
			}
		}
		
		bw.write(score1 + " " + score2 + "\n");

		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(x, y));
		visit[x][y] = true;
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Pair cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(check(nx, ny)) continue;
                
				if(visit[nx][ny]) continue;
                
				if(!map[cur.x][cur.y].equals(map[nx][ny])) continue;
				
				cnt++; 
				queue.offer(new Pair(nx, ny));
				visit[nx][ny] = true;
				
			}
		}
		
		return cnt;
	}
	
	public static boolean check(int x, int y) {
		return x < 0 || x >= m || y < 0 || y >= n;
	} 
    
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}