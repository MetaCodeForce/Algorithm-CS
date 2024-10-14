class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while (left <= right) {
        	mid = (left + right) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	}
        	
        	if (nums[left] <= nums[mid]) {
        		// 왼쪽 정상 배열
        		if (nums[left] > target || nums[mid] < target) {
        			// 오른쪽 탐색
        			left = mid + 1;
        		} else {
        			// 왼쪽 탐색
        			right = mid - 1;
				}
        	} else {
        		// 오른쪽 정상 배열
        		if (nums[right] < target || nums[mid] > target) {
        			// 왼쪽 탐색
        			right = mid - 1;
        		} else {
        			// 오른쪽 탐색
        			left = mid + 1;
				}
        	}
		}
        
		return -1;
    }
}