import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int A = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, A));
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int binarySearch(int arr[], int find) {
        int mid ;
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            mid = (left+right)/2;

            if (arr[mid] == find){
                return 1;
            }

            if(find <arr[mid]){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }

        return 0;
    }
}
