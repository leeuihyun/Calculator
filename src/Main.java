public class Main {

  public static void main(String[] args) {
    ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
    Display<Double> display = new Display<>();

    while (true) {
      display.printStart();

      String firstNumberStr = display.inputStr("첫번째 양의 정수 입력 : ");
      double firstNumber;

      try {
        firstNumber = Double.parseDouble(firstNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }
      arithmeticCalculator.setFirstNumber(firstNumber);

      String secondNumberStr = display.inputStr("두번째 양의 정수 입력 : ");
      double secondNumber;

      try {
        secondNumber = Double.parseDouble(secondNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }

      arithmeticCalculator.setSecondNumber(secondNumber);

      String operatorStr = display.inputStr("사칙연산을 입력하세요 (PLUS, MINUS, MULTIPLY, DIVIDE) : ");
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

      display.printResult(arithmeticCalculator.getResultList());

      String standardNumberStr = display.inputStr("입력받은 값보다 큰 결과값 들을 출력하겠습니다. 값을 입력하세요 : ");
      double standardNumber;

      try {
        standardNumber = Double.parseDouble(standardNumberStr);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        continue;
      }

      display.printBigList(standardNumber, arithmeticCalculator.getResultList());

      String continueCheckStr = display.inputStr("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      if (continueCheckStr.equals("exit")) {
        display.printResult(arithmeticCalculator.getResultList());
        break;
      }
    }
  }
}