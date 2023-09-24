import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int sendCount = 0;
    static int receivedCount = 0;
    static Queue[] send;
    static Queue<String> received = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        init();

        if (sendCount != receivedCount) {
            System.out.println("Impossible");
            System.exit(0);
        }

        while (!received.isEmpty()) {

            String target = received.poll();

            boolean isContains = false;
            for (int i = 0; i < N; i++) {
                if (!send[i].isEmpty() && send[i].peek().equals(target)) {
                    send[i].poll();
                    isContains = true;
                    break;
                }
            }

            if (!isContains) {
                System.out.println("Impossible");
                System.exit(0);
            }
        }

        System.out.println("Possible");

    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        send = new Queue[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            send[i] = new LinkedList<String>();

            while (st.hasMoreTokens()) {
                send[i].add(st.nextToken());
                sendCount++;
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            received.add(st.nextToken());
            receivedCount++;
        }

    }

}