import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArithmeticCalculator<Number> arithmeticCalculator = new ArithmeticCalculator<>();

    while (true) {
      System.out.println("----계산기 실행----");

      System.out.print("첫번째 양의 정수 입력 : ");
      String firstNumberStr = scan.next();
      Number firstNumber = 0;

      if (firstNumberStr.contains(".")) {
        firstNumber = Double.parseDouble(firstNumberStr);
      } else {
        firstNumber = Integer.parseInt(firstNumberStr);
      }

      arithmeticCalculator.setFirstNumber(firstNumber);

      System.out.print("두번째 양의 정수 입력 : ");
      String secondNumberStr = scan.next();
      Number secondNumber = 0;

      if (secondNumberStr.contains(".")) {
        secondNumber = Double.parseDouble(secondNumberStr);
      } else {
        secondNumber = Integer.parseInt(secondNumberStr);
      }

      arithmeticCalculator.setSecondNumber(secondNumber);

      System.out.print("사칙연산을 입력하세요 (PLUS, MINUS, MULTIPLY, DIVIDE) : ");
      String operatorStr = scan.next();
      if (!Operator.opContain(operatorStr)) {
        System.out.println("올바르지 않은 사칙연산 문자열입니다. 재시작합니다.");
        continue;
      }
      arithmeticCalculator.setSign(Operator.valueOf(operatorStr).getSign());

      try {
        arithmeticCalculator.calculate();
      } catch (Exception e) {
        System.out.println(e);
      }

      arithmeticCalculator.printResult();

      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      String continueCheckStr = scan.next();

      if (continueCheckStr.equals("exit")) {
        arithmeticCalculator.printResult();
        break;
      }
    }
  }
}