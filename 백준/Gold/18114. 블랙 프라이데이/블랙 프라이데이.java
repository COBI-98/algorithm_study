import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int C;
    static List<Integer> w = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            w.add(Integer.parseInt(st.nextToken()));

            if (w.get(i) == C) {
                System.out.println(1);
                return;
            }
        }
        
        Collections.sort(w);

        int start = 0;
        int end = N - 1;
        int weight;

        while (start < end) {
            weight = w.get(start) + w.get(end);

            if (weight > C) {
                end--;
            } else if (weight == C) {
                System.out.println(1);
                return;
            } else {
                if (start < w.indexOf(C - weight) && w.indexOf(C - weight) < end) {
                    System.out.println(1);
                    return;
                }
                start++;
            }
        }

        System.out.println(0);
    }
}