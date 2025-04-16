import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int result = 0;

    while(true) {
      System.out.println("---계산기 실행---");

      System.out.print("첫번째 양의 정수 입력 : ");
      int firstNumber = scan.nextInt();
      if(firstNumber < 0) {
        System.out.println("첫번째 양의 정수가 0보다 작습니다.(재시작합니다)");
        continue;
      }

      System.out.print("두번째 양의 정수 입력 : ");
      int secondNumber = scan.nextInt();
      if(secondNumber < 0) {
        System.out.println("두번째 양의 정수가 0보다 작습니다.(재시작합니다)");
        continue;
      }

      System.out.print("사칙연산 기호를 입력하세요: ");
      char sign = scan.next().charAt(0);
      switch (sign) {
        case '+' -> result = firstNumber + secondNumber;
        case '-' -> result = firstNumber - secondNumber;
        case '*' -> result = firstNumber * secondNumber;
        case '/' -> {
          if(secondNumber!=0) {
            result = firstNumber / secondNumber;
          }else {
            System.out.println("나누기 연산은 두번째 값이 0이 될 수 없습니다.(재시작합니다)");
            continue;
          }
        }
      }

      System.out.println("결과 : " + result);

      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
      String continueCheckStr = scan.next();

      if(continueCheckStr.equals("exit")) {
        break;
      }else {
        continue;
      }
    }
  }
}