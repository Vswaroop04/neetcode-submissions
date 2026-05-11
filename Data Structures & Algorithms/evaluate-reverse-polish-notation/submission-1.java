class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            if (
                s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/")
            ) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (s.equals("+")) {
                    result = a + b;
                }

                if (s.equals("-")) {
                    result = a - b;
                }

                if (s.equals("*")) {
                    result = a * b;
                }

                if (s.equals("/")) {
                    result = a / b;
                }

                stack.push(result);

            } else {

                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}