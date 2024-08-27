import java.math.BigDecimal;

class Solution {
    public int myAtoi(String s) {
        int result = 0;

        // 공백 제거
        s = s.trim();
        Boolean isMinus = false;

        // 자리수 체크
        if (s.length() == 0) {
            return 0;
        }

        // 음수 체크
        if ("-".equals(String.valueOf(s.charAt(0)))) {
            isMinus = true;
            s = s.substring(1);
            // 양수 체크
        } else if ("+".equals(String.valueOf(s.charAt(0)))) {
            isMinus = false;
            s = s.substring(1);
        }

        // 숫자 쌓기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char iter_s = s.charAt(i);
            if (Character.isDigit(iter_s)) {
                sb.append(iter_s);
                // 범위 때문에 끊기
            } else if (sb.length() > 10) {
                break;
            } else {
                break;
            }
        }

        // 자리수 체크
        if (sb.length() == 0) {
            return 0;
        }

        // 결과 설정
        BigDecimal bd = new BigDecimal(sb.toString());
        // 음수라면
        if (isMinus) {
            bd = bd.multiply(new BigDecimal(-1));
        }

        // 범위설정
        BigDecimal minValue = new BigDecimal(-2147483648);
        BigDecimal maxValue = new BigDecimal(2147483647);
        if (sb.length() > 0) {
            if (bd.compareTo(minValue) < 0) {
                result = minValue.intValue();
            } else if (bd.compareTo(maxValue) > 0) {
                result = maxValue.intValue();
            } else {
                result = bd.intValue();
            }
        }

        return result;
    }
}