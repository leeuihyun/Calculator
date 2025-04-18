import java.util.List;
import java.util.Scanner;

public class Display<T extends Number> {

  private final Scanner scan;

  public Display() {
    scan = new Scanner(System.in);
  }

  public void printStart() {
    System.out.println("----계산기 실행----");
  }

  public void printEnd() {
    System.out.println("----계산기 종료----");
  }

  public String inputStr(String inputStr) {
    System.out.print(inputStr);
    return this.scan.next();
  }

  public void printBigList(T number, List<T> resultList) {
    System.out.println("----출력 시작----");
    resultList.stream().filter(v -> v.doubleValue() > number.doubleValue())
        .forEach(v -> System.out.print(v + " "));
    System.out.println();
    System.out.println("----출력 종료----");

  }

  public void printResult(List<T> resultList) {
    System.out.println("----리스트 출력 시작----");
    for (Number result : resultList) {
      System.out.print(result + " ");
    }
    System.out.println();
    System.out.println("----리스트 출력 종료----");
  }
}
