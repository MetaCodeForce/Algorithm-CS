import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0; i< numRows;i++){ //i층!
            List<Integer> row  =new ArrayList<>();
            row.add(1);//왼쪽

            for(int j=1; j<i; j++){//행
                int val = triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j);
                row.add(val);
            }

            if(i>0){ //오른쪽
                row.add(1);
            }
            triangle.add(row);
        }
        return triangle;
        
    }
}