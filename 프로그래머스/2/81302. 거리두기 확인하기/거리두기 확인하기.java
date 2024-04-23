import java.util.*;

class Solution {

    private static final int[][] mapper = {{0,0,-1,1},{-1,1,0,0}};

    private static final int DISTANCE_SAFE = 1;
    private static final int DISTANCE_VIOLATED = 0;

    private static final int MIN_ISOLATION_DISTANCE = 3;
    private static final int WAITING_ROOM_SIZE = 5;

    private static final char PERSON = 'P';
    private static final char EMPTY_TABLE = 'O';
    private static final char PARTITION = 'X';

    public int[] solution(String[][] places) {
        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < places.length; i++) {
             if (isIsolatedWell(places[i])) {
                answers.add(DISTANCE_SAFE);
             } else {
                answers.add(DISTANCE_VIOLATED);
             }
        }

        return answers.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }

    private boolean isIsolatedWell(String[] places) {
         for (int y = 0; y < WAITING_ROOM_SIZE; y++) {
            for (int x = 0; x < WAITING_ROOM_SIZE; x++) {
                char now = places[y].charAt(x);   
                if (now == PERSON) {
                    if (!(checkDistanceByBFS(new Point(y, x), places))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean checkDistanceByBFS(Point start, String[] places) {
        boolean[][] visited = new boolean[WAITING_ROOM_SIZE][WAITING_ROOM_SIZE];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(start);
        visited[start.y][start.x] = true;
        int depth = 0;    

        while (!queue.isEmpty()) {
            if (depth == 2) return true;
            depth++;

            int size = queue.size();            
            for (int i = 0; i < size; i++) { 
                Point now = queue.poll(); 


                for (int dir = 0; dir < 4; dir++) {
                    int ny = now.y + mapper[0][dir];
                    int nx = now.x + mapper[1][dir];

                    if (isRange(nx, ny) || visited[ny][nx] 
                        || places[ny].charAt(nx) == PARTITION) continue;

                    char nextVal = places[ny].charAt(nx);
                    Point next = new Point(ny, nx);

                    if (nextVal == PERSON) {
                        return false;
                    }

                    visited[ny][nx] = true;
                    queue.offer(next);
                }
            }   
        }

        return true;
    }
    
    private static boolean isRange(int nx, int ny) {
        return ny < 0 || ny >= WAITING_ROOM_SIZE || nx < 0 || nx >= WAITING_ROOM_SIZE;
    }

    static class Point {
        private int y;
        private int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}