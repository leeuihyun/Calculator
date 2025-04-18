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

  public List<T> getResultList() {
    return resultList;
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
      double doubleResult = Math.round(result * 1000.0) / 1000.0;
      resultList.add((T) Double.valueOf(doubleResult));
    }
  }

  public boolean isInteger(T number) {
    return number.doubleValue() % 1 == 0.0;
  }
}
