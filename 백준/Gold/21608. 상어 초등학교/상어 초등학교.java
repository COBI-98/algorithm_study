import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int STUDENT_TOTAL_NUM;
    static final int FAVORITE_STUDENT = 4;
    static int ans = 0;
    static int[] students;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] classroom;
    static Map<Integer, Set<Integer>> preferences;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        printResult();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        classroom = new int[N][N];
        STUDENT_TOTAL_NUM = N * N;

        students = new int[STUDENT_TOTAL_NUM];
        preferences = new HashMap<>();

        for (int i = 0; i < STUDENT_TOTAL_NUM; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            students[i] = idx;
            preferences.put(idx, new HashSet<>());

            for (int j = 0; j < FAVORITE_STUDENT; j++) {
                preferences.get(idx).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void solution() {
        for (int i = 0; i < students.length; i++) {
            Seat seat = findSeat(students[i]);
            classroom[seat.x][seat.y] = students[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = getStudentSum(i, j, classroom[i][j]);
                if (count > 0) {
                    ans += (int) Math.pow(10, count - 1);
                }
            }
        }
    }

    static Seat findSeat(int idx) {
        Seat seat = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (classroom[i][j] > 0) {
                    continue;
                }

                Seat cur = new Seat(i, j, getStudentSum(i, j, idx), getEmptySum(i, j));

                if (seat == null) {
                    seat = cur;
                    continue;
                }

                if (seat.compareTo(cur) > 0) {
                    seat = cur;
                }
            }
        }
        return seat;
    }

    static int getStudentSum(int x, int y, int student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isRange(nx, ny)) {
                continue;
            }

            if (preferences.get(student).contains(classroom[nx][ny])) {
                count++;
            }
        }

        return count;
    }

    static int getEmptySum(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny)) {
                continue;
            }
            
            if (classroom[nx][ny] == 0) {
                count++;
            }
        }

        return count;
    }

    private static boolean isRange(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= N;
    }

    static void printResult() {
        System.out.println(ans);
    }

    static class Seat implements Comparable<Seat> {
        int x, y, studentSum, emptySum;

        public Seat(int x, int y, int studentSum, int emptySum) {
            this.x = x;
            this.y = y;
            this.studentSum = studentSum;
            this.emptySum = emptySum;
        }

        // 다른 좌석과 비교
        @Override
        public int compareTo(Seat other) {
            // 인접 좋아하는 학생 수로 비교
            if (studentSum != other.studentSum) {
                return -(studentSum - other.studentSum);
            }

            // 인접 빈칸 수로 비교
            if (emptySum != other.emptySum) {
                return -(emptySum - other.emptySum);
            }

            // 행으로 비교
            if (x != other.x) {
                return x - other.x;
            }

            // 열로 비교
            return y - other.y;
        }
    }
    
}