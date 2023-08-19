import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static boolean[] goalArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String given = br.readLine();
        String goal = br.readLine();

        boolean[] givenArrayTypeA = new boolean[n];
        boolean[] givenArrayTypeB = new boolean[n];
        goalArray = new boolean[n];

        for (int i = 0; i < n; i++) {
            givenArrayTypeA[i] = given.charAt(i) != '0';
            givenArrayTypeB[i] = given.charAt(i) != '0';
            goalArray[i] = goal.charAt(i) != '0';
        }

        greedyChoice(1, 0 , givenArrayTypeA);
        greedyChoice(1, 1 , usingSwitch(0, givenArrayTypeB));

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void greedyChoice(int index, int count, boolean[] givenArray) {
        if (index == n) {
            if (givenArray[index - 1] == goalArray[index - 1]) {
                answer = Math.min(answer, count);
            }
            return;
        }

        if (givenArray[index - 1] != goalArray[index - 1]) {
            greedyChoice(index + 1, count + 1, usingSwitch(index, givenArray));
        } else {
            greedyChoice(index + 1, count, givenArray);
        }
    }

    static boolean[] usingSwitch(int index, boolean[] givenArray) {
        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < n) {
                givenArray[i] = !givenArray[i];
            }
        }
        return givenArray;
    }
}