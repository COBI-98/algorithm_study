import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int x = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        boolean isStringInNumber = true;

        if(x < len) {
            isStringInNumber =false;
        }
        if (x / 26 > len) {
            isStringInNumber = false;
        }
        if (x / 26 == len && x % 26 != 0) {
            isStringInNumber = false;
        }

        if (isStringInNumber) {
            char list[] = new char[len];
            x-=len;
            for (int i = len - 1; i >= 0; i--) {
                list[i] = 'A';
                if (x >= 25) {
                    x -= 25;
                    list[i] +=25;
                } else if(x>0 && x<25){
                    list[i]+=x;
                    x=0;
                }
                sb.append(list[i]);
            }
            sb.reverse();

            System.out.println(sb);
        }else {
            System.out.println('!');
        }
    }

}
