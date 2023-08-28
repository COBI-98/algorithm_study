import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            Line line1 = new Line(new Point(x1, y1), new Point(x2, y2));
            Line line2 = new Line(new Point(x3, y3), new Point(x4, y4));

            if(line1.isInf && line2.isInf) {
                if(line1.s.x == line2.s.x) {
                    sb.append("LINE\n");
                }
                else {
                    sb.append("NONE\n");
                }
            }
            else if(line1.isInf) {
                double x = line1.s.x;
                double y = x * line2.gradient + line2.yIntercept;
                sb.append(String.format("POINT %.2f %.2f\n", x, y));
            }
            else if(line2.isInf) {
                double x = line2.s.x;
                double y = x * line1.gradient + line1.yIntercept;
                sb.append(String.format("POINT %.2f %.2f\n", x, y));
            }
            else if(line1.gradient == line2.gradient) {
                if(line1.yIntercept == line2.yIntercept) {
                    sb.append("LINE\n");
                }
                else {
                    sb.append("NONE\n");
                }
            }
            else {
                double x = (line2.yIntercept - line1.yIntercept) / (line1.gradient - line2.gradient);
                double y = x * line1.gradient + line1.yIntercept;
                sb.append(String.format("POINT %.2f %.2f\n", x, y));
            }
        }
        System.out.println(sb);
    }
    
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point s;
        Point e;
        double gradient;
        double yIntercept;
        boolean isInf;

        public Line(Point s, Point e) {
            this.s = s;
            this.e = e;
            if(s.x == e.x) {
                isInf = true;
            }
            else {
                isInf = false;
                this.gradient = 1.0 * (s.y-e.y) / (s.x-e.x);
                this.yIntercept = s.y - gradient * s.x;
            }
        }
    }
}
