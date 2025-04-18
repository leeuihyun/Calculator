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
      case '+' -> (Double) firstNumber + (Double) secondNumber;
      case '-' -> (Double) firstNumber - (Double) secondNumber;
      case '*' -> (Double) firstNumber * (Double) secondNumber;
      case '/' -> {
        if ((Double) secondNumber == 0.0) {
          throw new Exception("나누기 연산은 두번째 숫자가 0이 될 수 없습니다. 재시작합니다.");
        }
        yield (Double) firstNumber / (Double) secondNumber;
      }
      default -> throw new Exception("존재하지 않는 연산자입니다.");
    };

    if (isInteger(this.firstNumber) && isInteger(this.secondNumber)) {
      resultList.add((T) Integer.valueOf((int) result));
    } else {
      double doubleResult = Math.round(result * 100.0) / 100.0;
      resultList.add((T) Double.valueOf(doubleResult));
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

  public boolean isInteger(T number) {
    System.out.println(number.doubleValue() % 1);
    return number.doubleValue() % 1 == 0.0;
  }
}
