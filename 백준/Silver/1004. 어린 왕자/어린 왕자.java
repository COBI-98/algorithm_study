import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int [] prince;
    static int [] rose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            prince = new int [2];
            rose = new int [2];
            prince[0] = Integer.parseInt(st.nextToken());
            prince[1] = Integer.parseInt(st.nextToken());
            rose[0] = Integer.parseInt(st.nextToken());
            rose[1] = Integer.parseInt(st.nextToken());

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean princeCheck = isPrinceWithSpace(r, x, prince, y);
                boolean roseCheck = isPrinceWithSpace(r, x, rose, y);

                if (princeCheck && roseCheck){
                    continue;
                }
                
                if (princeCheck || roseCheck){
                    count++;
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    private static boolean isPrinceWithSpace(int r, int x, int[] node, int y) {

        if (Math.pow(r,2) > ((Math.pow(x - node[0],2)) + (Math.pow(y - node[1],2)))){
            return true;
        }

        return false;
    }
}
