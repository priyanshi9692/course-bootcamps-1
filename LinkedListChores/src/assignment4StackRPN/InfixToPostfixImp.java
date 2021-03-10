package assignment4StackRPN;

import java.util.Stack;

public class InfixToPostfixImp {
    /*
    The method precedence provides predence of the operators, if a character is an operator
    then we decide what is its precedence because in postfix notation we have to put them as
    per their precedence order only.
    */
    public static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /*
        To convert any given expression from infix to postfix,
        1. whenever we encounter a character which is letter or say digit
        (in the given expression every operand is a letter), we append that into result string,
        2. whenever we encounter a open parentheses we add that into the stack,
        3. we start popping out from the stack when we encounter a close parentheses till we encounter
        open parentheses,
        4. based on the precedence of the operator we arrange them into the resultant string
     */
    static String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expression.length() ; i++)
        {
            char c = expression.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+= c;
            }else if(c == '('){
                stack.add(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!= '('){
                    result+= stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    result+= stack.pop();
                }
                stack.add(c);
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "A+B*(C^D-E)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + infixToPostFix(exp));
    }
}
