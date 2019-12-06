package ictgradschool.industry.questions;

import org.apache.commons.jexl3.*;

public class CodeQuestion implements IQuestion {
    private String question;
    private String skeletonCodeStart;
    private String skeletonCodeEnd;
    private String expectOutcome;
    private boolean evaled;

    private JexlContext jc ;
    private JexlEngine jexl;

    public CodeQuestion(String question, String skeletonCodeStart, String skeletonCodeEnd, String[][]scopeVariables, String expectOutcome) {
        this.question = question;
        this.skeletonCodeStart = skeletonCodeStart;
        this.skeletonCodeEnd = skeletonCodeEnd;
        this.expectOutcome = expectOutcome;
        this.evaled = false;

        JexlContext jc = new MapContext();
        JexlEngine jexl = new JexlBuilder().create();
        for (String[] scopeVariable : scopeVariables) {
            jc.set(scopeVariable[0], Double.parseDouble(scopeVariable[1]));
        }
    }

    @Override
    public void printQuestion() {
        System.out.println("Have a look at the following code. Please write an expression between the ***  so that " + expectOutcome + ".");
        System.out.println(skeletonCodeStart);
        System.out.println("***\n***");
        System.out.println(skeletonCodeEnd);
    }

    @Override
    public boolean isValidAnswer(String userAnswer) {
        try {
            JexlExpression e = jexl.createExpression(userAnswer);
            e.evaluate(jc);
        } catch(JexlException e) {
            return false;
        }
        evaled = true;
        return true;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if (!evaled) {
            JexlExpression e = jexl.createExpression(userAnswer);
            e.evaluate(jc);
        }
        JexlExpression testE= jexl.createExpression("isRight = " + expectOutcome);
        testE.evaluate(jc);
        return Boolean.parseBoolean((String)jc.get("isRight"));
    }
}
