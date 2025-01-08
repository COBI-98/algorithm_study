import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int A, B, N, M;
	static boolean[] visited;
	static class Node {
		int x, moveCount;
		public Node(int x, int moveCount) {
			this.x = x;
			this.moveCount = moveCount;
		}
	}
	
	public static void main(String[] args) {
		A = scanner.nextInt();
		B = scanner.nextInt();
		N = scanner.nextInt();
		M = scanner.nextInt();
		visited = new boolean[100001];
		
		System.out.println(bfsMove(N));
	}
	
	static int bfsMove(int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.x == M) {
				return cur.moveCount;
			}
			
			int qx = cur.x;
			int[] nextX = {qx + 1, qx - 1, qx + A, qx - A, qx + B, qx - B, qx * A, qx * B};
			int nextMoveCount = cur.moveCount + 1;
			
			for(int i = 0; i < 8; i++) {
				if(nextX[i] >= 0 && nextX[i] <= 100000 && !visited[nextX[i]]) {
					queue.offer(new Node(nextX[i], nextMoveCount));
					visited[nextX[i]] = true;
				}
			}
		}
		
		return -1;
	}
}