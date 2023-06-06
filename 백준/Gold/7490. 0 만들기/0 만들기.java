import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Main {
    static int[] operator;
    static int[] num;
    static Stack<String> stack = new Stack<>();
    static List<StringBuilder> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            num = new int[input];
            for (int j = 0; j < input; j++) {
                num[j] = j + 1;
            }
            operator = new int[input - 1];
            Arrays.fill(operator, -1);

            dfs(0, input - 1, input);
            Collections.sort(answer);
            for (StringBuilder s : answer)
                System.out.println(s);
            System.out.println();
            answer.clear();
        }
    }

    public static void dfs (int start, int end, int input) {
        if (start == end) {
            stack.add(String.valueOf(num[0]));
            for (int i = 0;  i < end; i++) {
                if (operator[i] == 0) {
                    stack.add("+" + num[i + 1]);
                }
                else if (operator[i] == 1) {
                    stack.push(stack.pop() + num[i + 1]);
                }
                else if (operator[i] == 2) {
                    stack.add(String.valueOf(-(num[i + 1])));
                }
            }
            int result = 0;
            
            for (String x : stack) {
                result += Integer.parseInt(x);
            }
            
            if (result == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < input + 1; i++)
                    sb.append(i);
                int idx = 1;
                for (int i : operator) {
                    if (i == 0)
                        sb.insert(idx, "+");
                    else if (i == 1)
                        sb.insert(idx, " ");
                    else
                        sb.insert(idx, "-");
                    idx += 2;
                }
                answer.add(sb);
            }
            stack.clear();
            return;
        }

        for (int i = 0; i < 3; i++) {
            operator[start] = i;
            dfs(start + 1, end, input);
            operator[start] = -1;
        }
    }

}