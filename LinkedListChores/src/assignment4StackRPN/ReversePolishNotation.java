package assignment4StackRPN;

import java.util.Stack;

public class ReversePolishNotation {
    /*
     The method stacky will evaluate Reverse Polish Notation.
     1. to evaluate the given string tokens, let's take a stack and when ever a number is encountered place that
     into the stack,
     2. now whenever we encounter a token which is operator, then we will pop numbers from the stack and evaluate
     value based on the given operator.
     3. Once the evaluation is done, keep placing the evaluated numbers in the stack again and so on.
     */
    public int stacky(String[] tokens)
    {
        // Intialize the stack and the variable
        Stack<String> stack = new Stack<String>();
        int x, y;
        String result = "";
        int get = 0;
        String choice;
        int value = 0;
        String p = "";
        // Operators string
        String operators = "+-/*";
        // Iterating to the each character
        // in the array of the string
        for (int i = 0; i < tokens.length; i++) {
             if(!operators.contains(tokens[i])){
                 stack.add(tokens[i]);
             }else {
                 choice = tokens[i];

                 switch (choice) {
                     case "+":
                         x = Integer.parseInt(stack.pop());
                         y = Integer.parseInt(stack.pop());
                         value = x + y;
                         result = p + value;
                         stack.add(result);
                         break;

                     case "-":
                         x = Integer.parseInt(stack.pop());
                         y = Integer.parseInt(stack.pop());
                         value = x - y;
                         result = p + value;
                         stack.add(result);
                         break;
                     case "*":
                         x = Integer.parseInt(stack.pop());
                         y = Integer.parseInt(stack.pop());
                         value = x * y;
                         result = p + value;
                         stack.add(result);
                         break;

                     case "/":
                         x = Integer.parseInt(stack.pop());
                         y = Integer.parseInt(stack.pop());
                         value = y / x;
                         result = p + value;
                         stack.add(result);
                         break;
                     default:
                         continue;
                 }

             }
        }

        // Method to convert the String to integer
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        // String Input
        String[] s
                = { "10", "6", "9", "3", "+", "-11", "*",
                "/", "*", "17", "+", "5", "+" };

        ReversePolishNotation str = new ReversePolishNotation();
        int result = str.stacky(s);
        System.out.println(result);
    }
}
