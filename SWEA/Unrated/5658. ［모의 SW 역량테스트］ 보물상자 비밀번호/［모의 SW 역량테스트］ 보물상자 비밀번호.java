import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            String str = br.readLine();

            int numLength = N / 4;

            HashSet<Integer> set = new HashSet<>();

            for (int k = 0; k < numLength; k++) {
                String changeStr = str.substring(N-k,N) + str.substring(0,N-k);
                for (int i = 0; i < 4; i++) {
                    String num = "";
                    for (int j = i*numLength; j <i*numLength + numLength; j++) {
                        num = num + changeStr.charAt(j);
                    }
                    set.add(Integer.parseInt(num,16));
                }
            }

            List<Integer> list = new ArrayList<>(set);

            Collections.sort(list,Collections.reverseOrder());


            sb.append("#"+tc+" "+list.get(K-1)+"\n");
        }

        System.out.println(sb);
    }
}
