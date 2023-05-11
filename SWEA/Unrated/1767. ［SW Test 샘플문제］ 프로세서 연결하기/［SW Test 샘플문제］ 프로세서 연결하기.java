import java.io.*;
import java.util.*;

class Solution{
    static class Processor{
		int row, col;
		Processor(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int[][] map;
	static int N,T;
	static int maxCore, minLength;
	static List<Processor> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
        StringTokenizer st;
        
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
		
			map = new int[N][N];
			list = new ArrayList<>();
            
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == 0 || j == 0 || i == N-1 || j == N-1)
						continue;
					if(map[i][j] == 1){
						list.add(new Processor(i,j));
                    }
				}
			}
            
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#" + tc + " " + minLength);
		}
	}
	private static void dfs(int idx, int coreCnt, int len) {
		
		if(idx == list.size()) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minLength = len;
			}else if(maxCore == coreCnt) {
				if(minLength > len){
                    minLength = len;
                } 
			}
			return;
		}
		
		int row = list.get(idx).row;
		int col = list.get(idx).col;
		
		for (int dir = 0; dir < 4; dir++) {
			int count = 0;
			int nx = row;
			int ny = col;
			int Srow = row;
			int Scol = col;
			
			while(true) {
				nx += dx[dir];
				ny += dy[dir];
				if(check(nx, ny)) break;
                
				if(map[nx][ny] == 1) { 
					count = 0;
					break;
				}
				count++;
			}
            
			//전선을 1로 채워준다.
			for (int i = 0; i < count; i++) {
				Srow += dx[dir];
				Scol += dy[dir];
				
				map[Srow][Scol] = 1;
			}
            
            // 코어를 만났다면 다음 코어로
			if(count == 0) dfs(idx+1, coreCnt, len);
			//전선과 연결이 가능
			else {
				//다음 코어로 이동(연결된 코어개수 증가 , 전선길이 증가)
				dfs(idx+1, coreCnt+1, len + count);
				
				Srow = row;
				Scol = col;
			
				//dfs가 끝나면 전선을 다시 0으로 바꿔준다.
				for (int i = 0; i < count; i++) {
					Srow += dx[dir];
					Scol += dy[dir];
					
					map[Srow][Scol] = 0;
				}
				
			}
			
		}
	}
	static boolean check(int nx, int ny) {
		return nx < 0 || nx >= N || ny < 0 || ny >= N;
	}
}