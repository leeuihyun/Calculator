import java.util.ArrayList;
import java.util.List;

public class Calculator {

  private Integer firstNumber;
  private Integer secondNumber;
  private char sign;
  private List<Integer> resultList;

  public void setFirstNumber(Integer firstNumber) {
    this.firstNumber = firstNumber;
  }

  public void setSecondNumber(Integer secondNumber) {
    this.secondNumber = secondNumber;
  }

  public void setSign(char sign) {
    this.sign = sign;
  }

  public Integer removeFirstResult() {
    return resultList.remove(0);
  }

  public boolean getListEmpty() {
    return resultList.isEmpty();
  }

  public void printResult() {
    System.out.println("----결과 출력 시작----");
    for (Integer result : resultList) {
      System.out.print(result + " ");
    }
    System.out.println();
    System.out.println("----결과 출력 종료----");
  }

  public boolean calculate() {
    if (resultList == null) {
      resultList = new ArrayList<>();
    }

    switch (sign) {
      case '+' -> resultList.add(firstNumber + secondNumber);
      case '-' -> resultList.add(firstNumber - secondNumber);
      case '*' -> resultList.add(firstNumber * secondNumber);
      case '/' -> {
        if (secondNumber != 0) {
          resultList.add(firstNumber / secondNumber);
        } else {
          System.out.println("나누기 연산은 두번째 값이 0이 될 수 없습니다.(재시작합니다)");
          return false;
        }
      }
    }
    return true;
  }
}
