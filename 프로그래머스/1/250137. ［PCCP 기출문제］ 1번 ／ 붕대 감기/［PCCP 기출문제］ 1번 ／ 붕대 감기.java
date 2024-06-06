// bandage = 시전 시간, 초당 회복량, 추가 회복량
// health = 최대 체력
// attacks = 공격 시간, 피해량
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int heal = 0;
        int temp = health;
        
        int idx = 0;
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            if(i != attacks[idx][0]) {
                temp += bandage[1];
                heal++;
                if(heal == bandage[0]) {
                    temp += bandage[2];
                    heal = 0;
                }
                if(temp > health) temp = health;
            } else {
                heal = 0;
                temp -= attacks[idx][1];
                idx++;
            }
            
            if(temp <= 0) return -1;
        }
        
        return temp;
    }
}