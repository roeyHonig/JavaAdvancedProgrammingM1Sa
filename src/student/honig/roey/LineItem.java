package student.honig.roey;

public class LineItem {
    private Item item;
    private int amount;
    private double total;

    public LineItem(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.total = amount * item.getValue();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "item=" + item +
                ", amount=" + amount +
                ", total=" + total + "\n";
    }
}
