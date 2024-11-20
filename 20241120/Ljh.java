class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i=1; i<numRows; i++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(1);
            result.add(currList);
            
            for(int j=0; j<i; j++) {
                int element = result.get(i).get(j) + result.get(i).get(j+1);
                currList.add(element);
            }
            currList.add(1);
            result.add(currList);
        }
        
        return result;
    }


//ㅠㅠ오답