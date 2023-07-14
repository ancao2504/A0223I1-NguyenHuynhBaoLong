package ss11_DSA_stack_queue.optional.binary;

import java.util.Stack;

public class CheckBracket {
    public static boolean checkBracket(String expression) {
        Stack<Character> stack = new Stack<>();
        Character[] closeBracket = {')', ']', '}'};
        Character[] openBracket = {'(', '[', '{'};

        for (Character character :expression.toCharArray()){
            if (contains(openBracket,character)) {
                stack.push(character);
            } else if (contains(closeBracket,character)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character openingBracket = stack.pop();
                if (getBracketIndex(openBracket,openingBracket) != getBracketIndex(closeBracket,character)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getBracketIndex(Character[] characters, Character character) {
        for (int i = 0; i < characters.length; i++) {
            if (character == characters[i]) {
                return i;
            }
        }
        return -1;
    }

    private static boolean contains(Character[] characters,Character character) {
        for (int i = 0; i < characters.length; i++) {
            if(character == characters[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String expression1="S+(a-]";
        System.out.println(checkBracket(expression1));
    }
}
