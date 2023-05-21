import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static List<Node> list[];
	static int ans;
	static boolean [] visited;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
		StringTokenizer st;
		for(int i=0; i<n-1 ;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B,cost));
			list[B].add(new Node(A,cost));
		}
		ans = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			dfs(i, 0);
		}
		System.out.println(ans);
	}
	private static void dfs(int idx, int cost) {
		for (Node node : list[idx]) {
			if(!visited[node.idx]) {
				visited[node.idx] = true;
				dfs(node.idx, cost + node.cost);
			}
		}
		
		ans = (ans < cost)? cost : ans;
	}
 
    static class Node{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}	
