import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ArrayList<BaseBall> question = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            question.add(new BaseBall(num, strike, ball));
        }

        for (int i = 123; i < 988; i++) {
            String candidate = Integer.toString(i);

            if (candidate.contains("0") || candidate.charAt(0) == candidate.charAt(1) ||
                    candidate.charAt(0) == candidate.charAt(2) || candidate.charAt(1) == candidate.charAt(2)) {
                continue;
            }

            boolean valid = true;

            for (BaseBall b : question) {
                int strikeNumber = 0;
                int ballNumber = 0;

                String questionStr = Integer.toString(b.num);

                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (candidate.charAt(j) == questionStr.charAt(k)) {
                            if (j == k) {
                                strikeNumber++;
                            } else {
                                ballNumber++;
                            }
                        }
                    }
                }

                if (strikeNumber != b.strike || ballNumber != b.ball) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                answer++;
            }
        }

        System.out.println(answer);

    }
    
    public static class BaseBall {
        int num;
        int strike;
        int ball;

        public BaseBall(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}