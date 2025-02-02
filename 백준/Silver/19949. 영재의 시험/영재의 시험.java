import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int[] inputs;
	static int[] answers;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		inputs = new int[10];
		for (int i = 0; i < 10; i++) {
			inputs[i] = Integer.parseInt(s[i]);
		}
		answers = new int[10];
		count = 0;
		solve(0);
		System.out.println(count);
	}
    
	private static void solve(int depth) {
		if (depth >= 10) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if (answers[i] == inputs[i])
					sum++;
				if (sum >= 5) {
					count++;
					return;
				}
			}
			return;
		}
		for (int i = 1; i <= 5; i++) {
			if (depth > 1 && (answers[depth - 1] == i && answers[depth - 2] == i)) {
				continue;
			}
			answers[depth] = i;
			solve(depth + 1);
		}
	}
}