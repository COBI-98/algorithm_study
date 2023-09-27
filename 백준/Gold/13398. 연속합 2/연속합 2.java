import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int n;
	static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		data = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp1 = new int[n];
		dp1[0] = data[0];

		int answer = dp1[0];
		for(int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i-1] + data[i], data[i]);
			answer = Math.max(answer, dp1[i]);
		}

		int[] dp2 = new int[n];
		dp2[n-1] = data[n-1];
		for(int i = n-2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i+1] + data[i], data[i]);
		}

		for(int i = 1; i < n - 1; i++) {
			int temp = dp1[i-1] + dp2[i+1];
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
	}
}