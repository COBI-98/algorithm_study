import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    static int result = 987654321;
    static String str;
    static int N;
    static int half;
    static Stack<String> stack;
    
    public int solution(String s) {
        str = s;
        N = s.length();
        half = N / 2;

        stack = new Stack<>();

        for (int i = 1; i <= half; i++) {
            solve(i);
        }
        
        if (result == 987654321){
            result = 1;
        }

        return result;
    }

    private static void solve(int range) {
        String answer = "";
        int count = 1;
        for (int i = 0; i < N; i = i + range) {
            String substring;
            if (i + range > N) {
                substring = str.substring(i);
            } else {
                substring = str.substring(i, i + range);
            }

            if (stack.isEmpty()) {
                count = 1;
                stack.add(substring);
            } else {
                if (stack.peek().equals(substring)) {
                    count++;
                } else {
                    if (count != 1) {
                        answer += (count + stack.pop());
                    }else{
                        answer += stack.pop();
                    }
                    count = 1;
                    stack.add(substring);
                }
            }

        }

        while (!stack.isEmpty()) {
            if (count != 1) {
                answer += (count + stack.pop());
            } else {
                answer += stack.pop();
            }
        }

        result = Math.min(result, answer.length());

    }
}