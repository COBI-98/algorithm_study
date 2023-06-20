import java.io.*;
import java.lang.StringBuilder;

public class Main {
    static int T;
    static int[] number = {1, 5, 10, 50, 100, 500, 1000};
    static String[] roma = {"I", "V", "X", "L", "C", "D", "M"};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int len = str.length();
            int sum = 0;
            String answer = "";
            if (str.charAt(0) >= 65 && str.charAt(0) <= 90) { // 문자
                str = str + " ";
                sum = numConversion(str, len, sum);

                sb.append(sum + "\n");
            } else {
                int num = Integer.parseInt(str);
                romaConversion(num, len);
            }
        }
        System.out.println(sb);
    }

    private static void romaConversion(int digit, int p) {
        for (int i = 1; i <= p; i++) {
            int mod = (int) Math.pow(10, p - i);
            int div = (digit / mod);
            div *= mod;
            if (div == 900 || div == 90 || div == 9) {
                if (div == 900)
                    sb.append("CM");
                else if (div == 90)
                    sb.append("XC");
                else
                    sb.append("IX");
            } else if (div == 400 || div == 40 || div == 4) {
                if (div == 400)
                    sb.append("CD");
                else if (div == 40)
                    sb.append("XL");
                else
                    sb.append("IV");
            } else {
                StringBuilder temp = new StringBuilder();
                char c = ' ';
                if (mod == 1000)
                    c = 'M';
                else if (mod == 100)
                    c = 'C';
                else if (mod == 10)
                    c = 'X';
                else
                    c = 'I';

                int count = digit / mod;

                if(count >= 5) {
                    if(count * mod >= 500)
                        temp.append("D");
                    else if(count * mod >= 50)
                        temp.append("L");
                    else if(count * mod >= 5)
                        temp.append("V");


                    count -= 5;
                }

                for(int j =0 ; j < count ; j++) {
                    temp.append(c);
                }

                sb.append(temp);
            }

            digit -= div;
        }
        sb.append("\n");
    }

    private static int numConversion(String str, int len, int sum) {
        for (int i = 0; i < len; i++) {
            String A = String.valueOf(str.charAt(i));
            String B = String.valueOf(str.charAt(i + 1));
            int a = -1;
            int b = -1;

            for (int k = 0; k < 7; k++) {
                if (roma[k].equals(A)) {
                    a = k;
                }
                if (roma[k].equals(B)) {
                    b = k;
                }
            }

            if (b == -1) {
                sum += number[a];
                break;
            }

            if (a >= b) {
                sum += number[a];
            } else {
                sum += (number[b] - number[a]);
                i++;
            }
        }
        return sum;
    }
}