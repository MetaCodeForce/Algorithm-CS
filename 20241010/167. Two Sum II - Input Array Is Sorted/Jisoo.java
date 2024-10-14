class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        int mid = 0;

        while (left < right) {
            if (sum == target) {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }

            mid = (left + right) / 2;

            if (sum < target) {
                while (numbers[mid] + numbers[right] > target && mid > left + 1) {
                    mid = (left + mid) / 2;
                }

                sum = numbers[mid] + numbers[right];
                left = mid;
                continue;
            }

            if (sum > target) {
                while (numbers[left] + numbers[mid] < target && mid < right - 1) {
                    mid = (mid + right) / 2;
                }

                sum = numbers[left] + numbers[mid];
                right = mid;
                continue;
            }
        }

        return answer;
    }
}