package twentyfour;

import org.apache.commons.jexl3.*;

public class NumbersGenerator {
    private int max_num = 20;
    private static final String[] ops = new String[]{"+", "-", "*", "/", "%"};


    public NumbersGenerator(int max_num) {
        this.max_num = max_num;
    }

    private int generateNumber() {
        return (int) (Math.random() * max_num);
    }

   NumAnsCombo generateCombo() {
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) nums[i] = generateNumber();
        String ans = haveSolution(nums);
        if (ans != null) return new NumAnsCombo(nums, ans);
        else return generateCombo();
    }

    String haveSolution(int[] nums) {
        JexlContext jc = new MapContext();
        jc.set("res", 0);
        JexlEngine jexl = new JexlBuilder().create();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int p = 0; p < 5; p++) {
                        String currExpression = generateExpression(p, ops[i], ops[j], ops[k], nums[0], nums[1], nums[2], nums[3]);
                        JexlExpression e = jexl.createExpression("res=" + currExpression);
                        //System.out.println(currExpression);
                        try {
                            e.evaluate(jc);
                        } catch (ArithmeticException | JexlException e1) {
                            continue;
                        }
                        int res = Integer.parseInt(jc.get("res").toString());
                        if (res == 24) {
                            return currExpression;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String generateExpression(int index, String ops1, String ops2, String ops3, int nums1, int nums2, int nums3, int nums4) {
        switch (index) {
            case 0:
                return "((" + nums1 + ops1 + nums2 + ")" + ops2 + nums3 + ')' + ops3 + nums4;
            case 1:
                return "(" + nums1 + ops1 + "(" + nums2 + ops2 + nums3 + "))" + ops3 + nums4;
            case 2:
                return "(" + nums1 + ops1 + nums2 + ")" + ops2 + "(" + nums3 + ops3 + nums4 + ")";
            case 3:
                return nums1 + ops1 + "((" + nums2 + ops2 + nums3 + ")" + ops3 + nums4 + ")";
            case 4:
                return nums1 + ops1 + "(" + nums2 + ops2 + "(" + nums3 + ops3 + nums4 + "))";
        }
        return null;
    }

}
