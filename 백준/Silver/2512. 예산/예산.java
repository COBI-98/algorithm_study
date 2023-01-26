import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static int N;
    public static int[] arr;

    public static int totalRequest;
    public static int totalMoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalRequest = totalRequest + arr[i];
        }
        totalMoney = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    public static long binarySearch(){

        if (totalRequest <= totalMoney){
            return arr[arr.length-1];
        }

        int left = 0;
        int right  = totalMoney;
        long answer = 0;
        while(left <= right){
            int sum = 0;
            int mid = (left + right) /2;

            for (int i = 0; i < N; i++) {
                if(arr[i] > mid){
                    sum += mid;
                }else{
                    sum += arr[i];
                }
            }

            if (sum > totalMoney){
                right = mid -1;
            }else {
                left = mid+1;
                answer = Math.max(answer,mid);
            }
        }

        return answer;

    }
}
