import java.io.*;
import java.util.*;

public class Main {
	
	private static long binary_search(long arr[], int N, long max) {
		long half = 0;
		long min = 1;

		while(min <= max) {
			half = (min + max)/2;
			long count = 0;

			for(long num : arr) {
				count += num / half;
			}
            
			if(count < N) {
				max = half-1;
			}
			else {
				min = half+1;
			}
		}
		return (max+min)/2;
	}

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long result = 0;
		long max = 0;

		long [] arr= new long[K];
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		result = binary_search(arr, N, max);

		System.out.println(result);
		br.close();
	}
}