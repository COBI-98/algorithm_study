import java.util.*;
class Solution {
    public static int [] answer = new int[2];
    public static int h;
    public static int w;
    public static int checkX;
    public static int checkY;
    
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        h = park.length; // height
        w = park[0].length(); // width
        
        String[][] copyPark = new String[h][w];
        
        for(int i=0; i<h; i++){
            String ch = park[i];
            for(int j=0;j<w; j++){
                String check = String.valueOf(ch.charAt(j));
                copyPark[i][j] = check;
                if(check.equals("S")){
                    checkX = j;
                    checkY = i;
                }
            }
        }
        
        
        return dfs(copyPark,routes,checkX,checkY);
    }
    
    public static int[] dfs(String [][] park, String[] routes, int x, int y){
        
        for(int i=0; i<routes.length;i++){
            boolean useStreet = true;
            String [] n_route = routes[i].split(" ");
            int nx, ny;
            
            if(n_route[0].equals("E")){
                nx = x + Integer.valueOf(n_route[1]);
                ny = y;
            } else if(n_route[0].equals("W")){
                nx = x - Integer.valueOf(n_route[1]);
                ny = y;
            } else if(n_route[0].equals("S")){
                nx = x;
                ny = y + Integer.valueOf(n_route[1]);
            } else{
                nx = x;
                ny = y - Integer.valueOf(n_route[1]);
            }
            
            if(nx<0 || ny<0 || nx>=w || ny >=h){
                
            }else{
                if(x == nx){
                    if(y>ny){
                        for(int j = ny;j<=y;j++){
                            if(park[j][x].equals("X")){
                                useStreet = false;
                            }
                        }    
                    }else{
                        for(int j = y;j<=ny;j++){
                            if(park[j][x].equals("X")){
                                useStreet = false;
                            }
                        }
                    }
                    
                }else{
                    if(x>nx){
                        for(int k = nx;k<=x;k++){
                            if(park[y][k].equals("X")){
                                useStreet = false;
                            }
                        }
                    }else{
                        for(int k = x;k<=nx;k++){
                            if(park[y][k].equals("X")){
                                useStreet = false;
                            }
                        }   
                    }
                }
                
                if(useStreet){
                    x = nx;
                    y = ny;
                }
            }
            
        }
        
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
}