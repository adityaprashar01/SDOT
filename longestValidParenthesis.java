import java.util.Scanner;
import java.util.Stack;
public class longestValidParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = longestValidParentheses(input);
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Push -1 to mark the start

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                stack.push(i); // Push index of '('
            } else {
                // Pop the last index
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i); // Update the last index
                } else {
                    // Calculate the length of current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
