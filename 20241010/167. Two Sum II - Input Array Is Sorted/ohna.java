class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;   //왼
        int right = numbers.length -1; //오
        int[] result = new int[2];

        for(int i=0;i<numbers.length;i++){
            int num = target - numbers[i]; // ex 9-2
            int index = search(numbers, i+1, numbers.length,  num);

            if(index != -1){
                result[0]=i+1;
                result[1]=index+1;
                return result;
            }
        }
        return result;
    }


    public int search(int[] nums ,int left, int right, int target) {
        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return -1; 
    }

}