public class PostfixEvaluator {
    public static double evaluate(String expression) {
        PostfixStack stack = new PostfixStack(50);
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double op2 = stack.pop();
                double op1 = stack.pop();
                double result = applyOperator(token.charAt(0), op1, op2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static double applyOperator(char op, double a, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            default: return 0;
        }
    }
}