import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] arr;
    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : arr) {
            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            }else {
                int left = 0;
                int right = lis.size() - 1;

                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (lis.get(mid) >= num) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                lis.set(right, num);
            }
        }

        
        
        System.out.println(lis.size());
    }
}
