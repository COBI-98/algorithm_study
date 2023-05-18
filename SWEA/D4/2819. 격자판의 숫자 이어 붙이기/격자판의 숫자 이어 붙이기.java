import java.util.*;
import java.io.*;
import java.lang.StringBuilder;
class Solution{
    static HashSet<String> set;
    static int[][] map;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
            map = new int[4][4];
            set = new HashSet<>();
            
            StringTokenizer st;
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    DFS(i, j, 0, "" + map[i][j]);
                }
            }
            sb.append("#" + test_case + " " + set.size()+"\n");
        }
        System.out.println(sb);
	}
    
    private static void DFS(int x, int y, int depth, String str) {
        if (depth == 6) {
            set.add(str);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i]; 
            if (nx >=0 && ny >= 0 && nx < 4 && ny < 4) {
                DFS(nx, ny, depth + 1, str + map[nx][ny]);
            }
        }
    }
    
}