import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int C;
    public static int [] home ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        System.out.println(divide());
    }

    public static int divide(){
        // 거리
        int lo = 1;
        int hi = home[N-1] - home[0];

        if (C == 2){
            return hi;
        }

        while (lo < hi){
            int mid = (lo + hi) / 2;

            int count = 1;
            int lastLocate = home[0];

            for(int i = 1; i < home.length; i++) {
                int curLocate = home[i];

                if(curLocate - lastLocate >= mid) {
                    count++;
                    lastLocate = curLocate;
                }
            }

            if (count < C){
                hi = mid;
            }else{
                lo = mid+1;
            }

        }


        return lo-1;
    }
}
