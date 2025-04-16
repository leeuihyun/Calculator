public enum Operator {
  PLUS('+'),
  MINUS('-'),
  MULTIPLY('*'),
  DIVIDE('/');

  private char sign;

  Operator(char sign) {
    this.sign = sign;
  }

  public char getSign() {
    return this.sign;
  }

  public static boolean opContain(String str) {
    for (Operator opt : Operator.values()) {
      if (opt.name().equalsIgnoreCase(str)) {
        return true;
      }
    }
    return false;
  }
}
