import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Main {
    static final String regex = ".*0.*";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int minClock = getMinClockNumber(input);
        Set<Integer> clockSet = new HashSet<>();
        Pattern p = Pattern.compile(regex);
        for (int i = 1111; i < minClock; i++) {
            String clockStr = String.valueOf(i);
            if (p.matcher(clockStr).matches()) continue;
            int[] clock = clockStr.chars()
                    .map(c -> c - '0')
                    .toArray();
            clockSet.add(getMinClockNumber(clock));
        }
        System.out.println(clockSet.size() + 1);
    }
    private static int getMinClockNumber(int[] clock) {
        int min = 10000;
        for (int i = 0; i < 4; i++) {
            int num = 0;
            int mul = 1000;
            for (int j = i; j < i + 4; j++) {
                num += clock[j % 4] * mul;
                mul /= 10;
            }
            min = Math.min(min, num);
        }
        return min;
    }
}