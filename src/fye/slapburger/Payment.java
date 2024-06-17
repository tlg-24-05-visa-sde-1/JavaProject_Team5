package fye.slapburger;

public class Payment {

    private static boolean processPayment(double amount) {
        System.out.println("Processing payment of $" + amount);
        return true;  // payment is always successful (at least for now)
    }
}
