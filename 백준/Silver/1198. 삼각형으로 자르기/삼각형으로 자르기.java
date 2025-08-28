import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] dots = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}

		double max = 0;
		double space;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					space = Math
							.abs(dots[i][0] * dots[j][1] + dots[j][0] * dots[k][1] + dots[k][0] * dots[i][1]
									- (dots[i][1] * dots[j][0] + dots[j][1] * dots[k][0] + dots[k][1] * dots[i][0]))
							/ 2.0;
					max = Math.max(max, space);
				}
			}
		}

		System.out.println(max);
	}
}