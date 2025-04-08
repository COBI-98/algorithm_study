import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> fruitCnt = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int rigth = 0; rigth < N; rigth++) {
            fruitCnt.put(fruits[rigth], fruitCnt.getOrDefault(fruits[rigth], 0) + 1);

            while (fruitCnt.size() > 2) {

                fruitCnt.put(fruits[left], fruitCnt.get(fruits[left]) - 1);
                if (fruitCnt.get(fruits[left]) == 0) {
                    fruitCnt.remove(fruits[left]);
                }
                left++;

            }
            maxLength = Math.max(rigth - left + 1, maxLength);
        }
        System.out.println(maxLength);


    }
}