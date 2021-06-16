import java.util.Scanner;
import java.util.Stack;

public class Calcul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> s = new Stack<Character>();
        String line = sc.nextLine();
        String postfix = ""; // 후위 표기식으로 바꾼 문자열

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != '+' && line.charAt(i) != '*')
                postfix += line.charAt(i); // 숫자인 경우 바로 넣어줌
            else {
                if (line.charAt(i) == '*') { // 곱셈인 경우 스택에 바로 push
                    s.push(line.charAt(i));
                } else {
                    do { // 덧셈인 경우 자기보다 우선순위가 높은 *을 빼고 push
                        if (s.isEmpty())
                            break;
                        postfix += s.pop();
                    } while (!s.isEmpty() && s.peek() != '+');
                    s.push(line.charAt(i));
                }
            }
        }
        while (!s.isEmpty()) {
            postfix += s.pop(); // 나머지 연산자
        }

        Stack<Integer> calc = new Stack<Integer>();
        for (int i = 0; i < postfix.length(); i++) {
            if (postfix.charAt(i) != '+' && postfix.charAt(i) != '*') // 피연산자인 경우 push
                calc.push(postfix.charAt(i) - '0');

            else { // 연산자가 나오면 맨 위의 두개를 빼서 계산후 push
                int op1 = calc.pop();
                int op2 = calc.pop();
                char operator = postfix.charAt(i);
                switch (operator) {
                case '*':
                    int times = op1 * op2;
                    calc.push(times);
                    break;
                case '+':
                    int plus = op1 + op2;
                    calc.push(plus);
                    break;
                }
            }
        }

        System.out.println("#" + calc.peek());
    }

}
