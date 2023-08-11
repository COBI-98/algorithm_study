import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 5;
    static long a;
    static long b;
    static int [] paperList = new int [MAX_SIZE];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        a = Long.parseLong(str.replace(".",""));
        b = (long) Math.pow(10, str.length() - 2); // length -1 (-1) -> "."
        long gcdNum = GCDCalculate(a, b);

        solve(gcdNum);
    }


    private static long GCDCalculate(long x, long y) {
        while(y != 0){
            long temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    private static void solve(long gcdNum) {
        a /= gcdNum;
        b /= gcdNum;

        long fiveNumberOfPaper = (a - b) / 4;

        paperList[4] += fiveNumberOfPaper;
        a -= fiveNumberOfPaper * 5;
        b -= fiveNumberOfPaper;

        if (a != b) {
            paperList[(int) (a - b)] += 1;
            paperList[0] += b - 1;
        } else {
            paperList[0] += b;
        }

        for (int paperNum : paperList) {
            System.out.print(paperNum + " ");
        }
    }
}