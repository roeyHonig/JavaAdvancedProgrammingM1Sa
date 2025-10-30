package student.honig.roey;

import java.util.ArrayList;

public class CashRegister {
    private ArrayList<LineItem> account = new ArrayList<>();
    private double sum = 0;

    public CashRegister() {
    }

    public CashRegister(double sum) {
        this.sum = sum;
    }

    public void addItem(Item item, int amount) {
        LineItem newItem = new LineItem(item, amount);
        account.add(newItem);

        return;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < account.size(); i++) {
            output += account.toString();
        }
        return output;
    }

    public double accountTotal() {
        double total = 0;
        for (int i = 0; i < account.size(); i++) {
            LineItem item = account.get(i);
            total += item.getTotal();
        }
        return total;
    }

    public double bill(double payment) {
        double change = payment-this.accountTotal();
        account = new ArrayList<>();
        sum += payment;
        sum -= change;
        return change;
    }

    public double getSum() {
        return sum;
    }
}
