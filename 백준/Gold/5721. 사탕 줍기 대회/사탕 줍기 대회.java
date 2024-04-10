import java.util.Scanner;

public class Main {

	static int M;
	static int N;
	static int[] nums;
	static int[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();

			if (M == 0 && N == 0)
				break;

			dp = new int[M + 1];

			for (int i = 1; i <= M; i++) {

				nums = new int[N + 1];

				for (int j = 1; j <= N; j++) {

					nums[j] = sc.nextInt();

					if (j >= 2) {
						nums[j] = Math.max(nums[j - 2] + nums[j], nums[j - 1]);
					}
				}

				dp[i] = nums[N];

				if (i >= 2) {
					dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
				}
			}

			System.out.println(dp[M]);
		}

		sc.close();
	}
}