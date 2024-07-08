/**
 * 작성자 : 이재훈
 * 스터디 일시 : 2024/6/27
 * 문제 : https://leetcode.com/problems/two-sum/
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};

        // for문을 안쓰기 위해 List로 변환하여 contains를 사용했지만 결과적으로 메모리최적화에는 별 도움이 안됐다..
        List<Integer> numsList = new ArrayList<>();
        for (int n : nums) {
            numsList.add(n);
        }
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            // && 뒷절을 씀으로써 자기 자신 중복은 제외
            if (numsList.contains(target-num) && i != numsList.indexOf(target-num)) {
                result[0] = i;
                result[1] = numsList.indexOf(target-num);
                return result;
            }
        }
        return result;
    }
}