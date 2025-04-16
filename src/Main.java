import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Calculator calculator = new Calculator();

    while(true) {
      System.out.println("----계산기 실행----");

      System.out.print("첫번째 양의 정수 입력 : ");
      int firstNumber = scan.nextInt();
      if(firstNumber < 0) {
        System.out.println("첫번째 양의 정수가 0보다 작습니다.(재시작합니다)");
        continue;
      }
      calculator.setFirstNumber(firstNumber);

      System.out.print("두번째 양의 정수 입력 : ");
      int secondNumber = scan.nextInt();
      if(secondNumber < 0) {
        System.out.println("두번째 양의 정수가 0보다 작습니다.(재시작합니다)");
        continue;
      }
      calculator.setSecondNumber(secondNumber);

      System.out.print("사칙연산 기호를 입력하세요: ");
      char sign = scan.next().charAt(0);
      calculator.setSign(sign);

      if(!calculator.calculation()) {
        continue;
      }

      calculator.printResult();

      if(!calculator.getListEmpty()) {
        System.out.print("결과리스트의 처음값을 삭제하시겠습니까? (Y) : ");
        char removeCheckStr = scan.next().charAt(0);

        if(removeCheckStr == 'Y'){
          calculator.removeFirstResult();
          calculator.printResult();
        }
      }

      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      String continueCheckStr = scan.next();

      if(continueCheckStr.equals("exit")) {
        calculator.printResult();
        break;
      }else {
        continue;
      }
    }
  }
}