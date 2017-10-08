package nl.sourcelabs.se.week5.monday.assignment3;

public class Transaction {
    
    private long id;
    private String from;
    private String to;
    private double amount;
    
    public Transaction(Transaction transaction) {
        this(transaction.from, transaction.to, transaction.amount);
    }

    public Transaction(String from, String to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
    
    public boolean isValid() {
        return from != null && to != null && amount > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Transaction that = (Transaction) o;

        if (id != that.id)
            return false;
        if (Double.compare(that.amount, amount) != 0)
            return false;
        if (from != null ? !from.equals(that.from) : that.from != null)
            return false;
        if (to != null ? !to.equals(that.to) : that.to != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", from='" + from + '\'' + ", to='" + to + '\'' + ", amount=" + amount + '}';
    }
}
