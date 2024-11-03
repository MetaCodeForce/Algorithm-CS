class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            int change = bills[i] - 5;

            if (change == 0) {
                five++;
                continue;
            }

            if (change == 5) {
                ten++;
            }

            if (change == 15 && ten > 0) {
                ten--;
                change = change - 10;
            }

            if (change > 0 && five >= change / 5) {
                five = five - change / 5;
                change = 0;
            }

            if (change > 0) {
                return false;
            }
        }

        return true;
    }
}