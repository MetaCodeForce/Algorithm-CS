class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) { //피벗이 없어

            return binarySearch(nums, target, 0, nums.length - 1);

        } else {
            int answer1 = binarySearch(nums, target, 0, pivot);

            int answer2 = binarySearch(nums, target, pivot + 1, nums.length - 1);

            if (answer1 == -1 && answer2 == -1) {//target이 양쪽 모두 없다면
                return -1;

            } else {//둘 중 한쪽엔 있으니
                if (answer1 != -1) {
                    return answer1;
                } else {
                    return answer2;
                }
            }
        }


    }

    int findPivot(int[] nums, int start, int end) {

        int middle = (start + end) / 2;

        if (nums[start] > nums[middle]) {
            return findPivot(nums, start, middle);

        } else if (nums[middle] > nums[end]) { // 이중에 피벗이 있다
            if (start == middle) {
                return middle;
            }

            return findPivot(nums, middle, end);

        } else {
            return -1;
        }
    }

    int binarySearch(int[] nums, int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            return middle;

        } else if (nums[middle] > target) {
            return binarySearch(nums, target, start, middle - 1);

        } else {
            return binarySearch(nums, target, middle + 1, end);
        }
    }

}