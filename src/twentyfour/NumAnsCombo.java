package twentyfour;

class NumAnsCombo {
    private int[] nums;
    private String ans;

    NumAnsCombo(int[] nums, String ans) {
        this.nums = nums;
        this.ans = ans;
    }

    String getAns() {
        return ans;
    }

    int[] getNums() {
        return nums;
    }
}