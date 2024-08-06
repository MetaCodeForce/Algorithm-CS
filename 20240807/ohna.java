import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s; //ex3 처리
        //s길이췤
        int len = s.length();
        // 1) 2차원배열이 생각났으나 열 해결 불가
        // 2) 리스트와 함께...
        boolean down = false; // 방향,,,내려간다~
        int index = 0; // 행 인덱스 ~~위치다....
        List<StringBuilder> resultList  = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            resultList.add(new StringBuilder());
        }

        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            resultList.get(index).append(c);

            if( index == 0 || index == numRows -1){ //처음이나 끝에선 방향바뀜
                down = !down; // f>t
            }
            // 방향에 맞게 행 인덱스 조정
            if(down){
                index++;
            }
            if(!down){
                index--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : resultList){
            result.append(sb);
        }
        return result.toString();
    }
}