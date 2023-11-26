import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int max = Integer.MIN_VALUE;

    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        boolean isDeadCheck = false;
        Player player = new Player(health, 0, 0);

        for (int i = 0; i < attacks.length; i++) {
            max = Math.max(max, attacks[i][0]);
        }

        Queue<Player> queue = new LinkedList<>();

        for (int i = 0; i < attacks.length; i++) {
            int curAttackTime = attacks[i][0];
            int curAttackDamage = attacks[i][1];

            queue.add(player);
            while (!queue.isEmpty()){
                Player cur = queue.poll();

                if (cur.idx + 1 == curAttackTime){
                    player = new Player(cur.health - curAttackDamage, cur.idx + 1, 0);
                    break;
                }

                if (cur.time + 1 == t){
                    int addHealth = HealthRange(health, cur.health, x);
                    queue.add(new Player(HealthRange(health, addHealth, y), cur.idx + 1, 1));
                }else{
                    queue.add(new Player(HealthRange(health, cur.health, x), cur.idx + 1, cur.time + 1));
                }
            }

             if (player.health <= 0){
                isDeadCheck = true;
                break;
            } 
        }

        if (isDeadCheck){
            answer = -1;
        }else{
            answer = player.health;
        }

        return answer;
    }

    private static int HealthRange(int health, int curHealth, int x) {
        if (curHealth + x >= health){
            return health;
        }
        return curHealth + x;
    }

    static class Player{
        int health;
        int idx;
        int time;

        public Player(int health, int idx, int time) {
            this.health = health;
            this.idx = idx;
            this.time = time;
        }
    }
}
