/**
 * 작성자 : 유태우
 * 스터디 일시 : 2024/6/27
 * 문제 : https://leetcode.com/problems/two-sum/
 */

public static HashSet<Integer> hw20240627(int[] input, int target, int[] output) {
    HashSet<Integer> answer = new HashSet<>();

    for (int i = 0; i < input.length; i++) {
        for (int j = i + 1; j < input.length; j++) {
            if (input[i] + input[j] == target) {
                System.out.println("correct " + input[i] + " " + input[j]);
                answer.add(i);
                answer.add(j);
            }
        }
    }

    System.out.println(answer);
    return answer;
}
