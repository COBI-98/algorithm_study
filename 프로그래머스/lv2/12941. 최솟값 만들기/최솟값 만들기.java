import java.util.*;
class Solution
{
    private static List<Integer> AList = new ArrayList<>();
    private static List<Integer> BList = new ArrayList<>();
    
    public int solution(int [] A, int [] B){
        int answer = 0;
        AList = listMake(A);
        BList = listMake(B);
        
        Collections.sort(AList);
        Collections.sort(BList, Collections.reverseOrder());
        
        for(int i = 0; i<AList.size();i++){
            answer = answer + (AList.get(i) * BList.get(i));
        }
        
        return answer;
    }
    
    public List<Integer> listMake(int [] Num){
        List<Integer> listSort = new ArrayList<>();
        for(int i =0;i<Num.length;i++){
            listSort.add(Num[i]);
        }
        return listSort;
    }
}