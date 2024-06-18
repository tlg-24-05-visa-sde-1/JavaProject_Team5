package fye.slapburger;

public class Payment {

    public static boolean processPayment(double amount, String method) {
        if (method.equalsIgnoreCase("card")) {
            System.out.println("Processing Card Payment of $" + amount);
            return false;
        } else if (method.equalsIgnoreCase("cash")) {
            System.out.println("Processing cash payment of $" + amount);   // payment is always successful (at least for now)
            return true;
        } else {
            return false;
        }
    }
}
