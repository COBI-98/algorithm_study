import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

class Solution{
    static int [][] map;
    static int [] dy = {1,-1,0};
    static int [] dx = {0,0,1};
    static boolean [][] visited;
    static boolean check;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= 10; test_case++){
			int N = Integer.parseInt(br.readLine());
            
            map = new int[100][100];
            visited = new boolean[100][100];
            check = false;
            StringTokenizer st;
            
            for(int i=0;i<100;i++){
                st = new StringTokenizer(br.readLine());
            	for(int j=0;j<100;j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int result = 0;
            
            for(int i=0;i<100;i++){
            	if(map[0][i] == 1){
        			dfs(0,i);
                    
                    if(check){
                    	result = i;
                        break;
                    }
                }
            }
            
            sb.append("#"+N+" "+result+"\n");
		}
        System.out.println(sb);
    }
    
    public static void dfs(int x, int y){
    	
        visited[x][y] = true;
        for(int k=0; k<3; k++){
         	int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx >= 0 && ny >=0 && ny <100 && nx <100){
            	if(map[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny);
                    visited[nx][ny] = false;
                    break;
                }else if (map[nx][ny] == 2){
                	check = true;
                }
            }
        }
    }
}