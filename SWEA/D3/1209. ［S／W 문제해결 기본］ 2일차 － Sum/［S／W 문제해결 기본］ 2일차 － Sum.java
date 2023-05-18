import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++){
            int tc = Integer.parseInt(br.readLine());
			int [][] map = new int[100][100];
            
            List<Integer> arr = new ArrayList<>();
            StringTokenizer st;
            
            for(int i=0; i<100;i++){
                int Xsum = 0;
            	st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++){
                	map[i][j] = Integer.parseInt(st.nextToken());
                    Xsum += map[i][j];
                }
                arr.add(Xsum);
            }
           
            for(int i=0;i<100;i++){
                 int Ysum =0;
            	for(int j=0;j<100;j++){
                	Ysum += map[j][i];
                }
                arr.add(Ysum);
            }
            
            int sum1 = 0;
            int sum2 = 0;
            for(int i=0;i<100;i++){
                for(int j=0;j<100;j++){
                	if(i == j){
                        sum1 += map[i][j];
                    }
                    
                    if(i+j == 99){
                    	sum2 += map[i][j];
                    }
                }
            }
            
            arr.add(sum1);
            arr.add(sum2);
            
            Collections.sort(arr, Collections.reverseOrder());
            
            sb.append("#"+test_case+" "+arr.get(0)+"\n");
		}
        
        System.out.println(sb);
	}
}