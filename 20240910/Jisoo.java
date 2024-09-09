class Solution {
    public boolean isMatch(String s, String p) {
        Queue<StringBuilder> stringQ = new LinkedList<>();
        stringQ.add(new StringBuilder(""));
        char before = '-'; // 이전에 체크한 문자

        for (int i = 0; i < p.length(); i++) {
            // * 건너뛰기 & 이미 검사한 내역 건너뛰기 (a*a*)
            if (p.charAt(i) == '*' || (before == p.charAt(i) && i < p.length() - 1 && p.charAt(i + 1) == '*')) {
                continue;
            }

            int stackNum = stringQ.size();
            while (stackNum > 0) {
                StringBuilder matchString = stringQ.poll();
                stackNum--;
                int idx = matchString.length();

                if (i == p.length() - 1 || p.charAt(i + 1) != '*') {
                    // 1. 다음 글자 * 아님 -> 한글자만 확인
                    if (idx >= s.length())
                        continue;
                    if (p.charAt(i) != '.' && s.charAt(idx) != p.charAt(i))
                        continue;

                    matchString.append(s.charAt(idx));
                    stringQ.add(matchString);
                    idx++;
                    before = '-';
                } else if (p.charAt(i) == '.') {
                    // 2. [.*] : 어떤 문자든 올 수 있음
                    stringQ.add(new StringBuilder(matchString));
                    while (idx < s.length()) {
                        StringBuilder newMatchString = new StringBuilder(matchString.append(s.charAt(idx)));
                        stringQ.add(newMatchString);
                        idx++;
                    }

                    before = p.charAt(i); // 이번 체크 문자
                } else {
                    // 3. [a*] : 한가지 문자만 여러번
                    stringQ.add(new StringBuilder(matchString));
                    while (idx < s.length() && s.charAt(idx) == p.charAt(i)) {
                        StringBuilder newMatchString = new StringBuilder(matchString.append(s.charAt(idx)));
                        stringQ.add(newMatchString);
                        idx++;
                    }
                    before = p.charAt(i); // 이번 체크 문자
                }
            }
        }

        while (!stringQ.isEmpty()) {
            if (s.equals(stringQ.poll().toString()))
                return true;
        }
        return false;
    }
}