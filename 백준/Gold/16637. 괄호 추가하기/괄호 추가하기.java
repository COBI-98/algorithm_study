import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    
    static int n;
    static String input;
	static int result = Integer.MIN_VALUE;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> operator = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = br.readLine();

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) nums.add(Character.getNumericValue(input.charAt(i)));
			else operator.add(input.charAt(i));
		}

		solve(0, nums.get(0));
		System.out.println(result);
	}

	private static void solve(int idx, int total) {
		if (idx == operator.size()) {
			result = Math.max(result, total);
			return;
		}
        
		int cal = calculate(total, nums.get(idx + 1), operator.get(idx));
		solve(idx + 1, cal);

		if (idx + 2 <= nums.size() - 1) {
			cal = calculate(total, calculate(nums.get(idx + 1), nums.get(idx + 2), operator.get(idx + 1)), operator.get(idx));
			solve(idx + 2, cal);
		}
	}

	private static int calculate(int a, int b, char oper) {
			if (oper == '-') return a - b;
			else if (oper == '+') return a + b;
			else return a * b;
	}
}