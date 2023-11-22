import java.util.*;

class Solution {

    static int N;

    public int[] solution(String[] id_list, String[] report, int k) {
        N = id_list.length;
        int[] answer = new int[N];

        Map<String, Integer> declarationMap = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            declarationMap.put(id_list[i], 0);
            map.put(id_list[i], new ArrayList<>());
        }

        for(int i=0; i<report.length;i++){
            String[] splitUser = report[i].split(" ");
            String userId = splitUser[0];
            String targetId = splitUser[1];

            List<String> strings = map.get(userId);

            if (!map.get(userId).contains(targetId)){
                declarationMap.put(targetId, declarationMap.get(targetId) + 1);
            }
            strings.add(targetId);
            map.put(userId, strings);
        }

        for (String user : declarationMap.keySet()) {
            if (declarationMap.get(user) >= k){

                for (int i = 0; i < N; i++) {
                    List<String> targetList = map.get(id_list[i]);

                    if (targetList.contains(user)){
                        answer[i]++;
                    }
                }

            }
        }

        return answer;
    }
}