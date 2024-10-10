import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int K;
    static List<List<Employee>> lines;
    static int result = 0;
    
    public static void main(String[] args) throws Exception {
        init();
        solve();
        printResult();
    }
    
    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lines = new ArrayList<>();
        for(int i=0; i<M; i++) {
            lines.add(new LinkedList<>());
        }
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            lines.get(i%M).add(new Employee(i%M, i, D, H));
        }
    }
    
    private static void solve() {
        PriorityQueue<Employee> pq = new PriorityQueue<>();
        Employee employee;
        
        for(int i=0; i<M; i++) {
            if(lines.get(i).isEmpty()) break;
            pq.offer(lines.get(i).remove(0));
        }
        int lineNum;
        while(!pq.isEmpty()) {
            employee = pq.poll();
            
            if(employee.num == K) break;
            
            lineNum = employee.lineNum;
            result++;
            if(lines.get(lineNum).isEmpty()) continue;
            
            pq.offer(lines.get(lineNum).remove(0));
        }
    }
    
    private static void printResult() {
        System.out.print(result);
    }
    
    static class Employee implements Comparable<Employee> {
        int lineNum;
        int num;
        int D;
        int H;
        public Employee(int lineNum, int num, int D, int H) {
            this.lineNum = lineNum;
            this.num = num;
            this.D = D;
            this.H = H;
        }
        
        @Override
        public int compareTo(Employee e) {
            if(this.D == e.D) {
                if(this.H == e.H) return this.lineNum - e.lineNum;
                return e.H - this.H;
            }
            return e.D - this.D;
        }
    }
    
}