import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Stack;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        Stack<Character> charStack = new Stack<Character>();
        Stack<String> stk = new Stack<String>();
        String line = sc.nextLine();
        for (int i = 0; i < line.length(); i++) {
            if (i == 0 && line.charAt(i) == '-') {
                str += "-";
            } else if (line.charAt(i) != '+' && line.charAt(i) != '*' && line.charAt(i) != '-' && line.charAt(i) != '/')
                // in case of numbers
                str += line.charAt(i);
            else {
                if (!str.isEmpty()) {
                    stk.push(str);
                    // System.out.println(" >"+str);
                    str = "";
                }

                if (line.charAt(i) == '*' || line.charAt(i) == '/') {
                    charStack.push(line.charAt(i));
                } else {
                    while (!charStack.isEmpty() && charStack.peek() != '+' && charStack.peek() != '-') {
                        if (charStack.isEmpty())
                            break;
                        str += charStack.pop();
                    }
                    charStack.push(line.charAt(i));
                }
            }

        }
        if (!str.isEmpty()) {
            stk.push(str);
            // System.out.println(" >>"+str);
            str = "";
        }

        // System.out.println(stk.size());
        // System.out.println(charStack.size());

        BigDecimal res = new BigDecimal("0.0");
        try {

            while (!charStack.isEmpty()) {
                BigDecimal op2 = new BigDecimal(stk.pop());
                BigDecimal op1 = new BigDecimal(stk.pop());

                char op = charStack.pop();
                switch (op) {
                case '*':
                    res = op1.multiply(op2);
                    break;
                case '+':
                    res = op1.add(op2);
                    break;
                case '-':
                    res = op1.subtract(op2);
                    break;
                case '/':
                    res = op1.divide(op2, 3, RoundingMode.CEILING );
                    break;
                }
                stk.push(res + "");

            }
        }catch(ArithmeticException ae){

        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(res.stripTrailingZeros().toPlainString());

    }
}