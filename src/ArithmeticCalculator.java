import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

  private T firstNumber;
  private T secondNumber;
  private char sign;
  private List<T> resultList;

  public void setFirstNumber(T firstNumber) {
    this.firstNumber = firstNumber;
  }

  public void setSecondNumber(T secondNumber) {
    this.secondNumber = secondNumber;
  }

  public void setSign(char sign) {
    this.sign = sign;
  }

  public void calculate() throws Exception {
    if (resultList == null) {
      resultList = new ArrayList<>();
    }

    double result = switch (this.sign) {
      case '+' -> firstNumber.doubleValue() + secondNumber.doubleValue();
      case '-' -> firstNumber.doubleValue() - secondNumber.doubleValue();
      case '*' -> firstNumber.doubleValue() * secondNumber.doubleValue();
      case '/' -> {
        if (secondNumber.doubleValue() == 0.0) {
          throw new Exception("나누기 연산은 두번째 숫자가 0이 될 수 없습니다. 재시작합니다.");
        }
        yield firstNumber.doubleValue() / secondNumber.doubleValue();
      }
      default -> throw new Exception("존재하지 않는 연산자입니다.");
    };

    if (this.firstNumber instanceof Double | this.secondNumber instanceof Double) {
      resultList.add((T) Double.valueOf(result));
    } else {
      resultList.add((T) Integer.valueOf((int) result));
    }
  }

  public void printBigList(T number) {
    resultList.stream().filter(v -> v.doubleValue() > number.doubleValue())
        .forEach(System.out::println);
  }

  public void printResult() {
    System.out.println("----결과 출력 시작----");
    for (Number result : resultList) {
      System.out.print(result + " ");
    }
    System.out.println();
    System.out.println("----결과 출력 종료----");
  }
}
