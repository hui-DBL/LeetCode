package at_2017.Before.num07;

import java.util.Stack;

/**
 * Created by zhonghui on 2017/7/5.
 */
public class ValidParentheses_1 {
    public static void main(String[] args) {
        String s = "[([]])";
        Solution_1 solution_1 = new Solution_1();
        System.out.println(solution_1.isValid(s));
    }
}

class Solution_1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {//类型不对 Character to String
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isParent(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isParent(char a, char b) {
        return (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}');
    }
}
