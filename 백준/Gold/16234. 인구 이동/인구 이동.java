import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Main{
 
 
    public static int n;
    public static int l;
    public static int r;
    public static int arr[][];
    public static boolean visit[][];
    public static int dirX[]={-1,1,0,0};
    public static int dirY[]={0,0,-1,1};
    public static int ans=0;
 
    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
 
    public static boolean check(int x,int y,int nx,int ny){
        int sub=Math.abs(arr[x][y]-arr[nx][ny]);
        if(sub>=l&&sub<=r){
            return true;
        }
 
        return false;
    }
 
 
 
    public static int move(){
        int unionCount=0;
        int unionSize=0;
 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
 
 
                    Queue<Node> queue=new LinkedList<Node>();
                    ArrayList<Node>list=new ArrayList<Node>();
                    queue.add(new Node(i,j));
                    list.add(new Node(i,j));
                    unionCount=arr[i][j];
                    visit[i][j]=true;
 
                    while(!queue.isEmpty()){
                        Node node=queue.poll();
                        for(int s=0;s<4;s++){
                            int nx=node.x+dirX[s];
                            int ny=node.y+dirY[s];
                            if(nx>=0&&nx<n&&ny>=0&&ny<n){
                                if(!visit[nx][ny]&&check(node.x,node.y,nx,ny)){
                                    queue.add(new Node(nx,ny));
                                    list.add(new Node(nx,ny));
                                    visit[nx][ny]=true;
                                    unionSize++;
                                    unionCount+=arr[nx][ny];
                                }
                            }
                        }
                    }
                    if(unionSize>0){
                        int avg=unionCount/list.size();
                        for(Node node:list){
                            arr[node.x][node.y]=avg;
                        }
                    }
                }
            }
        }
 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visit[i][j]=false;
            }
        }
 
 
        return unionSize;
 
    }
 
    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        arr=new int[n][n];
        visit=new boolean[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
 
 
 
        boolean isFlag=true;
        while(isFlag){
            if(move()==0){
                isFlag=false;
            }else{
                ans++;
            }
        }
 
        System.out.println(ans);
 
 
 
 
    }
}
