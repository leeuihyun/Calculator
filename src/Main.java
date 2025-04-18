import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();

    while (true) {
      System.out.println("----계산기 실행----");

      System.out.print("첫번째 양의 정수 입력 : ");
      String firstNumberStr = scan.next();
      double firstNumber;

      try {
        firstNumber = Double.parseDouble(firstNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }
      arithmeticCalculator.setFirstNumber(firstNumber);

      System.out.print("두번째 양의 정수 입력 : ");
      String secondNumberStr = scan.next();
      double secondNumber;

      try {
        secondNumber = Double.parseDouble(secondNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
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
        continue;
      }

      arithmeticCalculator.printResult();

      System.out.print("입력받은 값보다 큰 결과값 들을 출력하겠습니다. 값을 입력하세요 : ");
      String standardNumberStr = scan.next();
      double standardNumber;

      try {
        standardNumber = Double.parseDouble(standardNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }

      arithmeticCalculator.printBigList(standardNumber);

      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      String continueCheckStr = scan.next();

      if (continueCheckStr.equals("exit")) {
        arithmeticCalculator.printResult();
        break;
      }
    }
  }
}