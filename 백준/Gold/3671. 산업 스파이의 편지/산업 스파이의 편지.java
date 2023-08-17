import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    private static boolean[] isPrime = new boolean[10000000];
    private static LinkedList<Integer> list = new LinkedList<>();
    private static int count;

    private static final char NEW_LINE = '\n';

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        calculatePrime();

        while(c-- > 0) {
            char[] paper = br.readLine().toCharArray();
            count = 0;

            for(int i = 0; i < paper.length; i++) {
                boolean[] used = new boolean[paper.length];
                backTracking(i, paper[i] + "", paper, used);
            }

            while(!list.isEmpty()) {
                int num = list.remove();
                isPrime[num] = true;
            }

            sb.append(count).append(NEW_LINE);
        }

        System.out.println(sb);
    }

    private static void calculatePrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < isPrime.length; i++) {
            if(!isPrime[i]) continue;

            for(int j = i + i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }
    }

    private static void backTracking(int idx, String current, char[] arr, boolean[] used) {
        if(current.length() > arr.length) return;
        int num = Integer.parseInt(current);

        used[idx] = true;

        if(isPrime[num]) {
            list.add(num);

            isPrime[num] = false;
            count++;
        }

        for(int i = 0; i < arr.length; i++) {
            if(used[i]) continue;

            String next = current + arr[i];
            backTracking(i, next, arr, used);
            used[i] = false;
        }
    }
    
}