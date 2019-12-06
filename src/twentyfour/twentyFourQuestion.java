package twentyfour;
import org.apache.commons.jexl3.*;

public class twentyFourQuestion implements IQuestion {
    private int a;
    private int b;
    private int c;
    private int d;
    private JexlContext jc ;
    private int result;

    public twentyFourQuestion(int a, int b, int c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        jc = new MapContext();
        jc.set("a", a);
        jc.set("b", b);
        jc.set("c", c);
        jc.set("d", d);
        jc.set("result", 0);
        result = 0;

    }

    @Override
    public void printQuestion() {
        System.out.println("Please write a java expression using ALL of a, b, c, d that evaluates to 24.");
        System.out.printf("Your numbers are: a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);

    }

    @Override
    public boolean isValidAnswer(String userAnswer) {

        if (userAnswer.indexOf('a') == -1 || userAnswer.indexOf('b') == -1 || userAnswer.indexOf('c')==-1 || userAnswer.indexOf('d')==-1)
        {
            System.out.println("You need to use ALL four of a,b,c,d!");
            return false;
        }
        for (char c : userAnswer.toCharArray()) {
            if (c <= '9' && c >='0') {
                System.out.println("You should not be using numbers!");
                return false;
            }
        }

        try{
            JexlEngine jexl = new JexlBuilder().create();
            JexlExpression e = jexl.createExpression("result = "+userAnswer);

            e.evaluate(jc);
        } catch (JexlException e) {
            System.out.println("Not a valid java expression!");
            return false;
        }
        try {
            result =  Integer.parseInt(jc.get("result").toString());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("You didn't get an integer result!");
            return false;
        }

    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if(result == 24) return true;
        System.out.println("Your result is " + result);
        return false;
    }
}
