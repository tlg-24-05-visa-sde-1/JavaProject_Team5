package fye.slapburger;

public class Payment {

  public static boolean processPayment(double amount, String method) {
    boolean success = false;
    if (method.equalsIgnoreCase("C")) {
      // payment is always successful (at least for now)
      success = true;
    } else if (method.equalsIgnoreCase("D")) {
      success = false;
    }
    return success;
  }
}
