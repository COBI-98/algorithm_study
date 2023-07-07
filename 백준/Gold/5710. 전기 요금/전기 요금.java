import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            int total = wattCalculate(A);
            int left = 0;
            int right = total / 2;
            while (left <= right) {
                int mid = (left + right) / 2;

                int sPrice = priceCalculate(mid);
                int nPrice = priceCalculate(total - mid);

                int diff = Math.abs(sPrice - nPrice);

                if (diff < B) {
                    right = mid - 1;
                } else if (diff > B) {
                    left = mid + 1;
                }else{
                    System.out.println(sPrice);
                    break;
                }
            }
        }
    }

    private static int wattCalculate(int price) {
        if (price <= 200) {
            return price / 2;
        } else if (price <= 29900) {
            return (price - 200) / 3 + 100;
        } else if (price <= 4979900) {
            return (price - 29900) / 5 + 10000;
        } else {
            return (price - 4979900) / 7 + 1000000;
        }
    }

    public static int priceCalculate(int watt) {
        if (watt <= 100) {
            return watt * 2;
        } else if (watt <= 10000) {
            return 200 + (watt - 100) * 3;
        } else if (watt <= 1000000) {
            return 200 + 29700 + (watt - 10000) * 5;
        } else {
            return 200 + 29700 + 4950000 + (watt - 1000000) * 7;
        }
    }
}