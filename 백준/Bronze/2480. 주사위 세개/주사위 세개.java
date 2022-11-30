import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] dice = scan.nextLine().split(" ");
        ArrayList diceList = new ArrayList();

        int max = 0;
        int same = 1;
        int ovl = 0;
        int price = 0;
        for(int i = 0; i < dice.length; i++) {
            int diceNum = Integer.parseInt(dice[i]);
            if (diceNum > max) {
                max = diceNum;
            }
            if (diceList.contains(diceNum)) {
                same += 1;
                ovl = diceNum;

            } else {
                diceList.add(diceNum);
            }

        } switch (same) {
            case 3 : price = 10000 + ovl * 1000;
            break;
            case 2 : price = 1000 + ovl * 100;
            break;
            case 1 : price = max * 100;
        }
        System.out.println(price);

    }
}

