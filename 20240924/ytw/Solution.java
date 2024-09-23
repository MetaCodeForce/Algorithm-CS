package ytw;

// Runtime 2ms        Beats 91.48%   
// Memory  46.40MB    Beats 95.59%

class Solution {
    public static void main(String[] args) {
        new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9);
        // new Solution().twoSum(new int[] { 2, 3, 4 }, 6);
        // new Solution().twoSum(new int[] { -1, 0 }, -1);
    }

    public int[] twoSum(int[] numbers, int target) {
        int leftPoint = 1;
        int rightPoint = numbers.length;

        int leftVal;
        int rightVal;

        int[] answer = null;

        while (answer == null) {

            // 변수 할당
            leftVal = numbers[leftPoint - 1];
            rightVal = numbers[rightPoint - 1];

            // 두 수의 합이 작으면 leftPointer >>
            if (target > leftVal + rightVal) {
                leftPoint++;

                // 두 수의 합이 크면 rightPointer <<
            } else if (target < leftVal + rightVal) {
                rightPoint--;
            }

            // 두 수의 합 검증
            if (target == leftVal + rightVal) {
                answer = new int[] { leftPoint, rightPoint };
            }
        }
        return answer;
    }
}