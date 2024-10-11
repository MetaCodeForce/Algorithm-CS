class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            sb[i] = new StringBuilder();
        }

        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;

        while (i<n) {
            // 내려가는 구간
            for (int j=0; j<numRows && i<n; j++) {
                sb[j].append(arr[i++]);
            }
            // 올라가는 구간 (맨 위행과 맨 아래행을 빼는 걸 고려해야 함)
            for (int j=1; j<numRows-1 && i<n; j++) {
                sb[numRows-j-1].append(arr[i++]);
            }
        }

        String answer="";
        StringBuilder ansSb = sb[0];
        for (int j=1; j<numRows; j++) {
            ansSb.append(sb[j]);
        }
        answer = ansSb.toString();

        return answer;
    }
}