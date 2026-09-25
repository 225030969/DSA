public class A3_Postfix {

    public static double evaluate(String expression) {
        A3_Stack stack = new A3_Stack(20);
        String[] tokens = expression.trim().split("\\s+");

        System.out.println("\n===== POSTFIX EVALUATION =====");
        System.out.println("Expression: " + expression);
        System.out.println();

        for (String token : tokens) {
            if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
                System.out.println("Operator '" + token + "': " + a + " " + token + " " + b + " = " + result);
                stack.display();
            } else {
                double number = Double.parseDouble(token);
                stack.push(number);
                System.out.println("Pushed number: " + number);
                stack.display();
            }
            System.out.println();
        }

        double finalResult = stack.pop();
        System.out.println("Final Result: " + finalResult);
        System.out.println("==============================\n");
        return finalResult;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }

    private static double applyOperator(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Unknown operator");
        }
    }
}