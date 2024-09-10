class Solution{
	pubcli Boolean isMatch(String s, String p){
		// Pattern 객체 생성
		Pattern pattern = Pattern.compile(p);
		
		// Matcher 객체 생성
		Matcher matcher = pattern.matcher(s);

		// 결과
		return matcher.matches();
	}
}