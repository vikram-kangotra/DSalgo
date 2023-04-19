
import java.util.Stack;
public class StackProblems2 {
    
    // Lets analyze different types of Expressions: Inflix, Prefix, Postfix

    /*
     * Infix: 2 + 3 * 4 - 5
     * Prefix: - + 2 * 3 4 5
     * Postfix: 2 3 4 * + 5 -
     */

    // Infix to Postfix

    /*
     * Algortithm:
     * 1. Initialize an empty stack - list
     * 2. Initialize an empty StringBuilder - result
     * 3. Iterate over the expression
     *      if the character is an operand, append it to the result with a space
     *      if the character is a Left Parenthesis, push it to the stack
     *      if the character is a Right Parenthesis, pop the stack until you find a Left Parenthesis and append each popped element to the result with a space
     *      if the character is an operator -
     *         if stack is empty, push the operator to the stack
     *          else
     *              compare the precedence of the operator with the top of the stack
     *           if the precedence of the operator is greater than the top of the stack, push the operator to the stack
     *            else
     *              pop the stack until the precedence of the operator is greater than the top of the stack and append each popped element to the result with a space
     *              push the operator to the stack
     *              (In case of equal precedence, use associativity rules)
     * 4. Pop the stack until it is empty and append the popped elements to the result with a space
     * 5. Return the result as a String
     * 
     */

     public String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            String ch = String.valueOf(exp.charAt(i));
            if (ch.equals("(")) {
                stack.push(ch);
            } else if (ch.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (isOperator(ch)) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && !stack.peek().equals("(") && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            } else {
                result.append(ch).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString().trim();
    }
    
    private boolean isOperator(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^");
    }
    
    private int precedence(String ch) {
        if (ch.equals("^")) {
            return 3;
        } else if (ch.equals("*") || ch.equals("/")) {
            return 2;
        } else if (ch.equals("+") || ch.equals("-")) {
            return 1;
        }
        return 0;
    }
    

    // Evaluation of Postfix Expression

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      perform the operation and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = performOperation(op1, op2, ch);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.pop();
    }

    private int performOperation(int op1, int op2, String ch) {
        if (ch.equals("+")) {
            return op1 + op2;
        } else if (ch.equals("-")) {
            return op1 - op2;
        } else if (ch.equals("*")) {
            return op1 * op2;
        } else if (ch.equals("/")) {
            return op1 / op2;
        } else if (ch.equals("^")) {
            return (int) Math.pow(op1, op2);
        }
        return 0;
    }

    // Infix to Prefix

    /*
     * Algorithm:
     * initialize an empty stack - list
     * initialize an empty StringBuilder - result
     * iterate over the expression from right to left
     *      if the character is an operand, append it to the result with a space
     *      if the character is a Right Parenthesis, push it to the stack
     *      if the character is a Left Parenthesis, pop the stack until you find a Right Parenthesis and append each popped element to the result with a space
     *      if the character is an operator -
     *        if stack is empty, push the operator to the stack
     *       else
     *         compare the precedence of the operator with the top of the stack
     *        if the precedence of the operator is greater than the top of the stack, push the operator to the stack
     *      else
     *       pop the stack until the precedence of the operator is greater than the top of the stack and append each popped element to the result with a space
     *      push the operator to the stack
     *     (In case of equal precedence, use associativity rules)
     * 4. Pop the stack until it is empty and append the popped elements to the result with a space
     * 5. Reverse the result and return it as a String
     */
    
    public String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(exp.charAt(i));
            if (ch.equals(")")) {
                stack.push(ch);
            } else if (ch.equals("(")) {
                while (!stack.isEmpty() && !stack.peek().equals(")")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (isOperator(ch)) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && !stack.peek().equals(")") && precedence(ch) < precedence(stack.peek())) {
                        result.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            } else {
                result.append(ch).append(" ");
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return reverse(result.toString().trim());
    }

    private String reverse(String exp) {
        StringBuilder result = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            result.append(exp.charAt(i));
        }
        return result.toString();
    }

    // Evaluation of Prefix Expression

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression from right to left
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      perform the operation and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = performOperation(op1, op2, ch);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.pop();
    }

    // Postfix to Prefix

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      append the operator to the popped elements and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public String postfixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = ch + op2 + op1;
                stack.push(result);
            } else {
                stack.push(ch);
            }
        }
        return stack.pop();
    }
    
    // prefix to postfix

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression from right to left
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      append the operator to the popped elements and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = op1 + op2 + ch;
                stack.push(result);
            } else {
                stack.push(ch);
            }
        }
        return stack.pop();
    }

    // Postfix to Infix

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      append the operator to the popped elements and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = "(" + op1 + ch + op2 + ")";
                stack.push(result);
            } else {
                stack.push(ch);
            }
        }
        return stack.pop();
    }

    // Prefix to Infix

    /*
     * Algorithm:
     * 1. Initialize an empty stack - list
     * 2. Iterate over the expression from right to left
     *      if the character is an operand, push it to the stack
     *      if the character is an operator, pop the top two elements from the stack
     *      append the operator to the popped elements and push the result to the stack
     * 3. Pop the stack and return the result
     */

    public String prefixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            String ch = String.valueOf(exp.charAt(i));
            if (isOperator(ch)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = "(" + op1 + ch + op2 + ")";
                stack.push(result);
            } else {
                stack.push(ch);
            }
        }
        return stack.pop();
    }
}
