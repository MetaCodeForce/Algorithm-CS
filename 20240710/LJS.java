/**
 * 작성자 : 이지수
 * 스터디 일시 : 2024/7/10
 * 문제 :
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

class Solution {
  /**
   * StringBuilder
   * Runtime 6 ms
   * Memory 45.5 MB
   */
  public int lengthOfLongestSubstring1(String s) {
    int endIdx = 0;
    int maxLen = 0;

    StringBuilder sb = new StringBuilder();

    while (endIdx < s.length()) {
      if (sb.indexOf(s.charAt(endIdx) + "") >= 0) {
        sb.delete(0, sb.indexOf(s.charAt(endIdx) + "") + 1);
      }
      sb.append(s.charAt(endIdx));
      endIdx++;

      if (sb.length() > maxLen)
        maxLen = sb.length();
    }

    return maxLen;
  }

  /**
   * ArrayList
   * Runtime 18 ms
   * Memory 42.6 MB
   */
  public int lengthOfLongestSubstring2(String s) {
    int endIdx = 0;
    int maxLen = 0;

    ArrayList<Character> list = new ArrayList<>();

    while (endIdx < s.length()) {
      while (list.contains(s.charAt(endIdx))) {
        list.remove(0);
      }

      list.add(s.charAt(endIdx));
      endIdx++;

      if (list.size() > maxLen)
        maxLen = list.size();
    }

    return maxLen;
  }

  /**
   * HashSet
   * Runtime 6 ms
   * Memory 44.7 MB
   */
  public int lengthOfLongestSubstring3(String s) {
    int startIdx = 0;
    int endIdx = 0;
    int maxLen = 0;

    HashSet<Character> set = new HashSet<>();

    while (endIdx < s.length()) {
      while (set.contains(s.charAt(endIdx))) {
        set.remove(s.charAt(startIdx));
        startIdx++;
      }

      set.add(s.charAt(endIdx));
      endIdx++;

      if (set.size() > maxLen)
        maxLen = set.size();
    }

    return maxLen;
  }

  /**
   * HashMap
   * Runtime 5 ms
   * Memory 44.2 MB
   */
  public int lengthOfLongestSubstring4(String s) {
    int startIdx = 0;
    int maxLen = 0;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i)) && startIdx < map.get(s.charAt(i)) + 1) {
        startIdx = map.get(s.charAt(i)) + 1;
      }

      map.put(s.charAt(i), i);

      if (i - startIdx + 1 > maxLen) {
        maxLen = i - startIdx + 1;
      }
    }

    return maxLen;
  }
}