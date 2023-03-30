class Solution {
    public static int minVal = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        
        for(int i=0; i<3; i++) {
            if(picks[i] != 0) {
                int[] picksClone = picks.clone();
                picksClone[i] = picksClone[i]-1;
                
                dfs(picksClone, minerals, i, 0, 0);
            }
        }
        
        return minVal;
    }
    
    public void dfs(int[] picks, String[] minerals, int pick, int loc, int sum) {
        
        // 정산 먼저 : 5개를 캔다.
        // loc(위치) 증가를 위해 i를 밖에 선언.
        int i=0;
        for(; i<5; i++) {
            
            if(loc+i >= minerals.length) {
                break;
            }
            
            if(pick == 0) {
                sum += 1;
            }
            else if(pick == 1) {
                if("diamond".equals(minerals[loc+i])) {
                    sum += 5;
                }
                else {
                    sum += 1;
                }
            }
            else {
                if("diamond".equals(minerals[loc+i])) {
                    sum += 25;
                }
                else if("iron".equals(minerals[loc+i])) {
                    sum += 5;
                }
                else {
                    sum += 1;
                }
            }
        }
        
        loc = loc + i;
        
        // 더 캘 광물이 없다.
        if(loc >= minerals.length) {
            // 최소값 호출
            if(minVal > sum) {
                minVal = sum;
            }
            return;
        }
        
        // 더 사용할 곡괭이가 없다.
        if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            if(minVal > sum) {
                minVal = sum;
            }
            return;
        }
        
        // 이전에 구한 값보다 크면 return
        if(sum >= minVal) {
            return;
        }
        
        for(i=0; i<3; i++) {
            if(picks[i] != 0) {
                //가용한 곡괭이가 남아있다면 재귀
                int[] picksClone = picks.clone();
                picksClone[i] = picksClone[i]-1;
                
                dfs(picksClone, minerals, i, loc, sum);
                
            }
        }
    }
}