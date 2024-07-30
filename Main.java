public class Main {

    public static void main(String[] args) {
        longestPalindrome(
                "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa");
    }

    public static String longestPalindrome(String s) {

        String maxString = "";

        // 좌항부터 진행
        for (int i = 0; i < s.length(); i++) {
            int rightPoint = s.length();
            int leftPoint = i;

            // 우Char 초기값 max로 두고 진행
            while (true) {
                rightPoint -= 1;
                System.out.println(leftPoint + " & " + rightPoint + "");
                if (leftPoint > rightPoint) {
                    break;
                }

                char leftChar = s.charAt(leftPoint);
                char rightChar = s.charAt(rightPoint);

                // 앞 뒤가 같은 문자를 만날때까지 진행
                if (leftChar == rightChar) {
                    String input = s.substring(leftPoint, rightPoint + 1);
                    Boolean bool_isPalindromic = isPalindromic(input);

                    // System.out.println("앞뒤가 같은문자 : " + input);
                    if (bool_isPalindromic == false) {
                        continue;
                    } else if (bool_isPalindromic == true) {
                        // leftPoint 고정값에서 갖는 최대 크기의 maxString
                        // System.out.println("isPalinromic : " + input);
                        if (maxString.length() < input.length()) {
                            System.out.println(maxString + "을" + input + "로 교체");
                            maxString = input;
                            break;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return maxString;
    }

    // input : String
    public static Boolean isPalindromic(String input) {
        int leftPoint = 0;
        int rightPoint = input.length() - 1;
        Boolean result = null;

        // case : ""
        if ("".equals(input))
            result = false;

        // case : aba
        // case : bb
        while (true) {
            if (leftPoint > rightPoint) {
                result = true;
                break;
            }
            char leftChar = input.charAt(leftPoint++);
            char rightChar = input.charAt(rightPoint--);
            if (leftChar == rightChar) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

}
