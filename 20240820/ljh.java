class Solution {
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            // 매번 연산이 맞는지 확인
            int overflowCheck = answer * 10 + x % 10;

            // 틀렸다면?
            if ((overflowCheck - x % 10) / 10 != answer) {
                return  0;
            }

            // 자릿수를 일의자리부터 왼쪽으로 한칸씩 보기 위해 10으로 나눠 몫만 남기기
            x /= 10;
            answer = overflowCheck;
        }

        return answer;
    }
}