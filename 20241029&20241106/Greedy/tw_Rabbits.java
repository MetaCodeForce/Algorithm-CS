// Runtime 3 ms Beats 60.00% 
// Memory 43.05 MB Beats 6.80%

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        int answer = 0;

        // <대답 i, 체크 i>
        Map<Integer, Integer> checkList = new HashMap<>();

        for (int i : answers) {
            // System.out.println("대상 i" + i);

            // 0으로 대답하는 토끼 = 유일한 색의 토끼
            if (i == 0) {
                answer += 1;
                continue;
            }

            // 1~N 대답하는 토끼
            // 1. 새로운 대답을 한 토끼
            else if (!checkList.containsKey(i)) {
                answer += i + 1; // 본인 토끼 포함
                checkList.put(i, 1);
            }

            // 2. 같은 대답을 한 토끼
            // 같은 색 무리로 먼저 생각하기
            else if (checkList.containsKey(i)) {
                // 본인토끼를 포함한 개체 수 보다 같은 대답을 한 토끼가 먼저 작다면 같은 무리의 토끼로 생각
                if (checkList.get(i) < i + 1) {
                    checkList.replace(i, checkList.get(i) + 1); // 카운트 증가
                }

                // 같은 대답을 한 개체가 무리 수보다 많음 = 다른 색상 무리 토끼
                else if (checkList.get(i) == i + 1) {
                    answer += i + 1; // 본인 토끼 포함
                    checkList.put(i, 1); // 카운트 초기화
                }
            }
            // System.out.println("answer" + answer);
            // System.out.println("checkList : " + checkList.toString());
        }

        return answer;
    }
}

// Greedy 알고리즘 관점의 풀이 해석
// 1. 탐욕적 선택 속성 (Greedy Choice Property)
// - 대상 토끼의 대답 속성(0, 1~N, 존재 무리)에 따라 무리 수 증가시킴

// 2. 최적 부분 구조 (Optimal Substructure)
// - 부분 최적해의 합 = 전체 최적해
// 어느 구간에서든 대상 토끼의 대답 여하에 따라 같은 체크 방식을 택할 수 있음