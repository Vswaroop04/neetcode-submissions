class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }
                char lastBracket = stack.pop();
                if (
                    (ch == ')' && lastBracket != '(') ||
                    (ch == '}' && lastBracket != '{') ||
                    (ch == ']' && lastBracket != '[')
                ) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}