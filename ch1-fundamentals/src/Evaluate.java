import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @date 05/23/2019
 * @author Junhao Wang
 */

public class Evaluate {

  /**
   * Push operands onto the operand stack.
   * Push operators onto the operator stack.
   * Ignore left parentheses.
   * On encountering a right parenthesis, pop an operator,
   *          pop the requisite number of operands, and
   *          push onto the operand stack the result.
   */
  public static void main(String[] args) {
    Stack<String> operators = new Stack<>();
    Stack<Double> operands = new Stack<>();
    while (!StdIn.isEmpty()) {
      // Read token, push if operator
      String s = StdIn.readString();
      if      (s.equals("("))  ; // do nothing
      else if (s.equals("+")) operators.push(s);
      else if (s.equals("-")) operators.push(s);
      else if (s.equals("*")) operators.push(s);
      else if (s.equals("/")) operators.push(s);
      else if (s.equals("sqrt")) operators.push(s);
      else if (s.equals(")")) {
        // Pop, evaluate, and push result if token is ")".
        String op = operators.pop();
        double val = operands.pop();
        if (op.equals("+")) val = operands.pop() + val; // notice the order
        if (op.equals("-")) val = operands.pop() - val;
        if (op.equals("*")) val = operands.pop() * val;
        if (op.equals("/")) val = operands.pop() / val; // exception if val = 0
        if (op.equals("sqrt")) val = Math.sqrt(val); // exception if val = 0
        operands.push(val);
      } else {
        // No operators. Push the operand.
        operands.push(Double.parseDouble(s));
      }
    }
    System.out.println(operands.pop());
  }
}
