class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0; // 왼쪽 포인터 0에서 시작
        int right = numbers.length - 1; // 오른쪽 포인터 맨 끝에서 시작
        int sum = numbers[left] + numbers[right];

        while (left < right) {
            // 합계 == target
            if (sum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }

            // 1. 합계가 더 작을 경우 -> 왼쪽 포인터 + 1
            if (sum < target) {
                sum = sum - numbers[left] + numbers[left + 1];
                left++;
            }

            // 2. 합계가 더 큰 경우 -> 오른쪽 포인터 - 1
            if (sum > target) {
                sum = sum - numbers[right] + numbers[right - 1];
                right--;
            }
        }

        return answer;
    }
}