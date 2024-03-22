//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
//substring
//.
//
//
//
//Example 1:
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
//Example 2:
//
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
//Example 3:
//
//Input: s = ""
//Output: 0
//
//
//Constraints:
//
//0 <= s.length <= 3 * 104
//s[i] is '(', or ')'.
import java.util.*;
public class Main {
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
