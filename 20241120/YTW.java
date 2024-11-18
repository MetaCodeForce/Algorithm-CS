//  Runtime 1 ms Beats 86.58% 
//  Memory 42.11 MB Beats 17.18%

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> answer = new ArrayList<>();

        // 각 행
        for (int i = 0; i < numRows; i++) {
            // n번째 행의 원소 개수는 n개
            int startIndex = 0, lastIndex = i;
            List<Integer> hang = new ArrayList<>();

            // 각 행, 각 원소 (j=인덱스)
            for (int j = 0; j < lastIndex + 1; j++) {

                int value = 1;
                if (j == startIndex || j == lastIndex) { // 첫, 마지막은 1
                    value = 1;
                } else {
                    // j:1 (1)
                    // j:2 (1 + 위j:2)
                    // j:3 (위j:2 + 위j:3)
                    // System.out.print(i+", ");
                    // System.out.println(j);
                    value = answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j);
                }
                hang.add(value);
            }

            answer.add(hang);

        }
        // System.out.println(answer);
        return answer;
    }
}