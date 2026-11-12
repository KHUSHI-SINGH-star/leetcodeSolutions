class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int i=0;
        while (i < bills.length ) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0)
                    return false;
                ten++;
                five--;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (ten == 0 && five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}