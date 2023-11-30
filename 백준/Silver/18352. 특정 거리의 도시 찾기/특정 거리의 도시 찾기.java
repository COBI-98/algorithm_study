import java.util.*;
import java.io.*;

public class Main {
    
	private static final int INF = Integer.MAX_VALUE;
	static List<List<City>> list = new ArrayList<>();
	static int dist[];
	static int N, M, K, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[N+1];
		Arrays.fill(dist, INF);
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}

		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.get(x).add(new City(y, 1));
		}

		dijkstra(X);

		for(int i=1; i<dist.length; i++) {
			if(dist[i] == K) {
				sb.append(i).append('\n');
			}
		}

		if(sb.length() == 0) {
			System.out.println(-1);
		} 
		else {
			System.out.println(sb);
		}

	}

	private static void dijkstra(int cityNum) {
		PriorityQueue<City> que = new PriorityQueue<>();
		boolean visit[] = new boolean[N+1];
		dist[cityNum] = 0;

		que.offer(new City(cityNum, 0));

		while( !que.isEmpty() ) {
			City city = que.poll();
			int num = city.cityNum;

			if(visit[num]) continue;

			visit[num] = true;

			for(City c : list.get(num)) {

				if( !visit[c.cityNum] && dist[c.cityNum] > (c.weight + dist[num]) ) {
					dist[c.cityNum] = c.weight + dist[num];
					que.offer(new City(c.cityNum, dist[c.cityNum]));
				}
			}			
		}

	}
    
    static class City implements Comparable<City> {
		int cityNum;
		int weight;

		public City(int cityNum, int weight) {
			this.cityNum = cityNum;
			this.weight = weight;
		}

		public int compareTo(City o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
    
}