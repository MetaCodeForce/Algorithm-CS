import java.util.HashMap;

/**
 * 작성자 : 이지수
 * 스터디 일시 : 2024/6/27
 * 문제 : https://leetcode.com/problems/two-sum/
 */

class Solution {
    public int[] twoSum1(int[] nums, int target) {
        int[] output = new int[2];
        int diff = 0;

        loop: for (int i = 0; i < nums.length - 1; i++) {
            diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == diff) {
                    output[0] = i;
                    output[1] = j;

                    break loop;
                }
            }
        }

        return output;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] output = new int[2];
        HashMap<Integer, Integer> intMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (intMap.containsKey(target - nums[i])) {
                output[0] = intMap.get(target - nums[i]);
                output[1] = i;

                break;
            }
            intMap.put(nums[i], i);
        }

        return output;
    }
}
