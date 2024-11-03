class Solution {
    public int numRabbits1(int[] answers) {
        Map<Integer, Integer> rabbitsMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < answers.length; i++) {
            int rabbit = answers[i] + 1;
            if (rabbitsMap.containsKey(answers[i]) && rabbitsMap.get(answers[i]) > 0) {
                rabbit = rabbitsMap.get(answers[i]);
            } else {
                sum += rabbit;
            }

            rabbitsMap.put(answers[i], rabbit - 1);
        }

        return sum;
    }

    public int numRabbits2(int[] answers) {
        int[] rabbitsMap = new int[1000];
        int sum = 0;

        for (int i = 0; i < answers.length; i++) {
            int rabbit = answers[i];
            if (rabbitsMap[rabbit] > 0) {
                rabbitsMap[rabbit]--;
            } else {
                sum += (rabbit + 1);
                rabbitsMap[rabbit] = rabbit;
            }
        }

        return sum;
    }
}