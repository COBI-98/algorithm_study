import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char map [][];
	static boolean visit[][];
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visit = new boolean[N][M];
		for(int i = 0 ; i < N ; i++)
			map[i] = br.readLine().toCharArray();
		int cnt = 0;
		for(int i= 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(dfs(i,j))
					cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	public static boolean dfs(int row, int col) {
		boolean result = false;
		if(row<0 || col <0 || row>=N || col>=M)
			return true;
		
		if(map[row][col] == 'T')
			return true;
		else if(map[row][col] == 'F')
			return false;
		
		if(visit[row][col]) {
			return false;
		}
		visit[row][col] = true;
		if(map[row][col] == 'D')
			result = dfs(row+1,col);
		else if(map[row][col] == 'U')
			result = dfs(row-1,col);
		else if(map[row][col] == 'R')
			result = dfs(row,col+1);
		else if(map[row][col] == 'L') 
			result = dfs(row,col-1);
		
		map[row][col] = result? 'T': 'F';
		return result;
		
		
	}
}