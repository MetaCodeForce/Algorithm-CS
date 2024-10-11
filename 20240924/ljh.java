class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        int left = 0;
        int right = numbers.length-1;

        // left포인터는 왼쪽에서 오른쪽으로
        // right포인터는 오른쪽에서부터 왼쪽으로
        // 서로 한칸씩 이동해서 찾는다.
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                answer[0] = ++left;
                answer[1] = ++right;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return answer;
    }
}