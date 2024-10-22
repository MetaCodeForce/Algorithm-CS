package ytw1010;

class Solution {
    public static void main(String[] args) {
        // new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9);
        // new Solution().twoSum(new int[] { 2, 3, 4 }, 6);
        // new Solution().twoSum(new int[] { -1, 0 }, -1);
        new Solution().twoSum(new int[] { 3,24,50,79,88,150,345 }, 200);
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
                // leftPoint++;
                leftPoint = this.binarySearchLogic(leftPoint, rightPoint);

                // 두 수의 합이 크면 rightPointer <<
            } else if (target < leftVal + rightVal) {
                // rightPoint--;
                rightPoint = this.binarySearchLogic(leftPoint, rightPoint);

            }

            // 두 수의 합 검증
            if (target == leftVal + rightVal) {
                answer = new int[] { leftPoint, rightPoint };
            }
        }
        return answer;
    }

    private int binarySearchLogic(int leftPoint, int rightPoint) {
        int diffOf2number = rightPoint - leftPoint;
        int targetIndex = diffOf2number/2 + leftPoint;
    
        // 중간값이 2개일 경우 왼쪽에 붙일것이냐, 오른쪽에 붙일 것이냐
        // diffOf2number/2의 값이 자연스레 몫이 나오므로 왼쪽에 붙음!
        return targetIndex;
    }
}

