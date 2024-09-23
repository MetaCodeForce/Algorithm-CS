class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;   //왼
        int right = numbers.length -1; //오
        int[] result = new int[2];

        while(true){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                result[0]=left+1;
                result[1]=right+1;
                break;
            }else if(sum < target ){
                left++;
            }else{ // sum > target
                right--;
            }
        }

        return result;

    }
}