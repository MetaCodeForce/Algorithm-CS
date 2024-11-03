class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

// Greedy 알고리즘 관점의 풀이 해석
// 1. 탐욕적 선택 속성 (Greedy Choice Property)
// - 각 고객의 지불 상황에서 가능한 최선의 잔돈 방식을 선택

// 2. 최적 부분 구조 (Optimal Substructure)
// - 고객이 한 명씩 순서대로 처리되므로, 현재까지의 고객들에게 올바르게 잔돈을 줄 수 있었다면, 다음 고객에게도 동일한 방법으로 최적의
// 잔돈을 줄 수 있습니다.