package week1;

/**
 * Created by Tim H on 31/1/2017.
 */
public class Calculator {
    public String input;

    public Calculator(String input) {
        this.input = input;
    }

    public double calculatePostfix() {
        String[] postfix = this.input.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        for (String step : postfix) {
            if (step.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (step.equals("-")) {
                Integer temp = stack.pop();
                stack.push(stack.pop() - temp);
            } else if (step.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (step.equals("/")) {
                Integer temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else {
                stack.push(Integer.parseInt(step));
            }
        }
        return stack.getTos();
    }
}
