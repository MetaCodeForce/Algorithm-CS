// Runtime 1 ms Beats 86.58%
// Memory 41.86 MB Beats 63.01%

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1); // 1
                } else {
                    line.add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
                }
            }

            pascal.add(line);
        }

        return pascal;
    }
}