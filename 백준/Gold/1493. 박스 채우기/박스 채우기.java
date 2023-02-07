import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int length, width, height;
    public static int N;
    public static int[] cubes;
    public static int minCount ;
    public static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());
        cubes = new int[20];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cubes[A] = B;
        }

        divide(length, width, height);

        if (flag) {
            System.out.println(minCount);
        } else {
            System.out.println(-1);
        }
    }

    public static void divide(int x, int y, int z) {
        if (x == 0 || y == 0 || z == 0) {
            return;
        }

        flag = false;
        int cubeLen = 0;

        for (int i = 19; i >= 0; i--) {
            if (cubes[i] == 0)            
            {
                continue;
            }

            cubeLen = 1 << i;            
            if (x >= cubeLen && y >= cubeLen && z >= cubeLen) {
                minCount++;               
                cubes[i]--;
                flag = true;
                break;
            }
        }

        if (!flag) {
            return;
        }

        divide(cubeLen, y - cubeLen, cubeLen);
        divide(x - cubeLen, y, cubeLen);
        divide(x, y, z - cubeLen);
    }
}
