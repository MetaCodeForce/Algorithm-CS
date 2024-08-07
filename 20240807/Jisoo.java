class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        int plus1 = 0, plus2 = 0;
        int idx = 0;

        sb.append(s.charAt(0));
        for (int i = 0; i < numRows; i++) {
            plus1 = (numRows - 1 - i) * 2;
            plus2 = i * 2;
            idx = i;

            while (idx < s.length()) {
                if (plus2 > 0 && idx < s.length())
                    sb.append(s.charAt(idx));
                idx = idx + plus1;
                if (plus1 > 0 && idx < s.length())
                    sb.append(s.charAt(idx));
                idx = idx + plus2;
            }
        }

        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        HashMap<Integer, StringBuilder> map = new HashMap<>();

        int idx = 0;
        int plus = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb = map.getOrDefault(idx, new StringBuilder());
            sb.append(s.charAt(i));
            map.put(idx, sb);

            idx = idx + plus;

            if (idx == -1 || idx == numRows) {
                idx = idx - plus;
            }

            if (idx == 0 || idx == numRows - 1) {
                plus = plus * (-1);
            }
        }

        sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(map.getOrDefault(i, new StringBuilder()));
        }

        return sb.toString();
    }
}