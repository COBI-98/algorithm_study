import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static int N;
	public static int M;
	public static int max = Integer.MIN_VALUE;
	public static int [] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		tree = new int[N+1];
		for(int i =0; i<N ; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max,tree[i]);
		}
		
		System.out.print(binarySearch(max));
		
	}
	
	public static int binarySearch(int max) {
		
		int min = 0;
		
		while(min < max) {
			int mid = (min+max) / 2;
			
			long sum =0;
			
			for(int i=0; i<N;i++) {
				if(tree[i]<mid) {
					continue;
				}
				sum += (tree[i] - mid);
			}
			if(sum < M) {
				max = mid;
			}else {
				min = mid+1;
			}
		}
		

		return min-1;
	}
}
