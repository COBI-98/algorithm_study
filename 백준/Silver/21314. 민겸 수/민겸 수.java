import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        String temp = "";
        for (char ch : input.toCharArray()) {
            if (ch != 'K') {
                temp += ch;
            } else {
                if (temp.length() > 0) {
                    max.append(new BigInteger(10+"").pow(temp.length()).multiply(new BigInteger(5+"")));
                    min.append(new BigInteger(10+"").pow(temp.length()-1)).append(5);
                } else {
                    max.append(5);
                    min.append(5);
                }
                temp = "";
            }
        }

        if (temp.length() > 0) {
            for (int i = 0; i < temp.length(); i++) {
                max.append(1);
            }
            min.append(new BigInteger(10+"").pow(temp.length()-1));
        }


        System.out.println(max);
        System.out.println(min);
    }
}