import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static List<Character>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new List[N];

        for (int i = 0; i < N; i++) {
            char[] strArr = br.readLine().toCharArray();
            arr[i] = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                arr[i].add(strArr[j]);
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int rotationDirection = Integer.parseInt(st.nextToken());

            list.clear();
            list.add(new Pair(num, rotationDirection));

            int leftIndex = num - 1;
            int rotate = rotationDirection * -1;
            while (leftIndex >= 0) {
                if (!arr[leftIndex + 1].get(6).equals(arr[leftIndex].get(2))) {
                    list.add(new Pair(leftIndex, rotate));
                    rotate *= -1;
                    leftIndex--;
                } else {
                    break;
                }
            }

            int rightIndex = num + 1;
            rotate = rotationDirection * -1;
            while (rightIndex < N) {
                if (!arr[rightIndex - 1].get(2).equals(arr[rightIndex].get(6))) {
                    list.add(new Pair(rightIndex, rotate));
                    rotate *= -1;
                    rightIndex++;
                } else {
                    break;
                }
            }

            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j).number;
                int dir = list.get(j).direction;

                if (dir == 1) {
                    arr[x].add(0, arr[x].remove(arr[x].size() - 1));
                } else if (dir == -1) {
                    arr[x].add(arr[x].remove(0));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].get(0) == '1') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static class Pair {
        int number;
        int direction;

        public Pair(int number, int direction) {
            this.number = number;
            this.direction = direction;
        }
    }
}