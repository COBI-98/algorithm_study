import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int r;
    public static int c;
    public static int size = 1;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2,N);
        divide(0, 0, N);
    }

    public static void divide(int x, int y, int nextSize) {

        while(size > 0) {
            size /= 2;
            if(r < x+size && c < y+size) {
                count += 0;
            }
            else if(r < x+size) {
                count += size * size;
                y += size;
            }
            else if (c < y+size) {
                count += size * size * 2;
                x += size;
            }
            else {
                count += size * size * 3;
                x += size;
                y += size;
            }


            // size가 1이 되면 종료.
            if(size == 1) {
                System.out.println(count);
                break;
            }
        }
    }
}
