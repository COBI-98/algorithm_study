public class Solution {

    static int n;
    static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] redVisited;
    static boolean[][] blueVisited;
    static Node redStart;
    static Node blueStart;
    static Node redEnd;
    static Node blueEnd;
    static int minDepth = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;

        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    redStart = new Node(i, j);
                    redVisited[i][j] = true;
                } else if (maze[i][j] == 2) {
                    blueStart = new Node(i, j);
                    blueVisited[i][j] = true;
                } else if (maze[i][j] == 3) {
                    redEnd = new Node(i, j);
                } else if (maze[i][j] == 4) {
                    blueEnd = new Node(i, j);
                }
            }
        }

        dfs(maze, blueStart, redStart, 0);
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }

    private static void dfs(int[][] maze, Node curBlue, Node curRed, int depth) {
        if (curBlue.equals(blueEnd) && curRed.equals(redEnd)){
            minDepth = Math.min(minDepth, depth);
            return;
        }

        if (curBlue.equals(blueEnd)){
            for (int i = 0; i < 4; i++) {
                int red_nx = curRed.x + dx[i];
                int red_ny = curRed.y + dy[i];

                if (isRange(red_nx, red_ny) && maze[red_nx][red_ny] != 5 && !redVisited[red_nx][red_ny]
                         && !isSamePlace(curBlue.x, curBlue.y, red_nx, red_ny)) {
                    Node nextRed = new Node(red_nx, red_ny);
                    redVisited[red_nx][red_ny] = true;
                    dfs(maze, curBlue, nextRed, depth + 1);
                    redVisited[red_nx][red_ny] = false;

                }
            }
        }else if (curRed.equals(redEnd)){
            for (int i = 0; i < 4; i++) {
                int blue_nx = curBlue.x + dx[i];
                int blue_ny = curBlue.y + dy[i];

                if (isRange(blue_nx, blue_ny) && maze[blue_nx][blue_ny] != 5 && !blueVisited[blue_nx][blue_ny]
                        && !isSamePlace(blue_nx, blue_ny, curRed.x, curRed.y)) {
                            Node nextBlue = new Node(blue_nx, blue_ny);
                            blueVisited[blue_nx][blue_ny] = true;
                            dfs(maze, nextBlue, curRed, depth + 1);
                            blueVisited[blue_nx][blue_ny] = false;
                }
            }
        }else{
            for (int i = 0; i < 4; i++) {
                int blue_nx = curBlue.x + dx[i];
                int blue_ny = curBlue.y + dy[i];

                if (isRange(blue_nx, blue_ny) && maze[blue_nx][blue_ny] != 5 && !blueVisited[blue_nx][blue_ny]) {
                    for (int j = 0; j < 4; j++) {
                        int red_nx = curRed.x + dx[j];
                        int red_ny = curRed.y + dy[j];
                        if (isRange(red_nx, red_ny) && maze[red_nx][red_ny] != 5 && !redVisited[red_nx][red_ny]
                                && !isSamePlace(blue_nx, blue_ny, red_nx, red_ny)
                            && !isChangePosition(curBlue, curRed, blue_nx, blue_ny, red_nx, red_ny)){

                            Node nextBlue = new Node(blue_nx, blue_ny);
                            Node nextRed = new Node(red_nx, red_ny);

                            blueVisited[blue_nx][blue_ny] = true;
                            redVisited[red_nx][red_ny] = true;
                            dfs(maze, nextBlue, nextRed, depth + 1);
                            blueVisited[blue_nx][blue_ny] = false;
                            redVisited[red_nx][red_ny] = false;
                        }
                    }
                }
            }
        }

    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    private static boolean isSamePlace(int blue_nx, int blue_ny, int red_x, int red_y) {
        return blue_nx == red_x && blue_ny == red_y;
    }
    
    private static boolean isChangePosition(Node curBlue, Node curRed, int blue_nx, int blue_ny, int red_nx, int red_ny) {
        return red_nx == curBlue.x && red_ny == curBlue.y && blue_nx == curRed.x && blue_ny == curRed.y;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

    }
}
