import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] minVal = new int[4];
	static Info[] foods;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {  // 최소 영양성분
			minVal[i] = Integer.parseInt(st.nextToken());
		}
		foods = new Info[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			foods[i] = new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

		}
		find(0,minVal[0],minVal[1],minVal[2],minVal[3],0);
		if(answer != Integer.MAX_VALUE) {
			System.out.println(answer);
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
	}
	static void find(int start, int p,int f, int s, int v, int cost) {
		if(p<=0 && f<=0 && s<=0 && v<=0) { 
			if(cost<answer) {
				sb = new StringBuilder();
				for(int i=0; i<N; i++) {
					if(visited[i]) sb.append((i+1)+" ");
				}
				answer = cost;
			}
		}

		for(int i=start; i<N; i++) {
			visited[i] = true;
			find(i+1,p-foods[i].p,f-foods[i].f,s-foods[i].s,v-foods[i].v,cost+foods[i].cost);
			visited[i] = false;
		}
	}


	static class Info{
		int p,f,s,v,cost;
		public Info(int p,int f,int s,int v,int cost) {
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.cost = cost;
		}
	}
}