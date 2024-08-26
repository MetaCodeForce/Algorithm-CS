class Solution {
    public int myAtoi_ver1(String s) {
        
		Pattern pattern = Pattern.compile("^\s*[-+]?[0-9]+");
		Matcher matcher = pattern.matcher(s);           
		
		if (matcher.find(0) && !matcher.group(0).isEmpty()) {
			String match = matcher.group(0).trim();
			BigDecimal big = new BigDecimal(match);
			
			if (big.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE)) > 0) {
				match = Integer.MAX_VALUE+""; 
			} 
			
			if (big.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE)) < 0) {
				match = Integer.MIN_VALUE+""; 
			} 
			
			return Integer.parseInt(match);
		}
		return 0;
    }

    public int myAtoi_ver2(String s) {
        s = s.trim();
        int sign = 1;

        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            sign = s.charAt(0) == '-' ? -1 : 1;
            s = s.substring(1);
        }

        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)) {
                break;
            }

            ans = ans * 10 + (c - 48);
            if (sign * ans >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * ans <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return sign * (int) ans;
    }

    public int myAtoi_ver3(String s) {
        s = s.trim();
        int sign = 1;

        if (s.length() > 0 && (s.charAt(0) == '-' || s.charAt(0) == '+')) {
            sign = s.charAt(0) == '-' ? -1 : 1;
            s = s.substring(1);
        }

        long ans = 0;
        int i = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - 48);
            if (sign * ans >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign * ans <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return sign * (int) ans;
    }
}
