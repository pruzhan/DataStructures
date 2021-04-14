package ParenthesesInCode;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
        if (isCorrect(test)) System.out.println("Success");
    }

    public static boolean isCorrect(String input) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> indexes = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                indexes.push(1+i);
            }
            if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
                if (!stack.empty() && (stack.peek() == '{' & input.charAt(i) == '}') |
                        (stack.peek() == '[' & input.charAt(i) == ']') |
                        (stack.peek() == '(' & input.charAt(i) == ')')) {
                    indexes.pop();
                    stack.pop();
                }
                else {
                    System.out.println(i + 1);
                    return false;
                }
            }
        }
        if (!indexes.empty()) {
            while (indexes.size() != 1) indexes.pop();
            System.out.println(indexes.pop());
            return false;
        }
        return stack.empty();
    }
}