package gamesys.presentation;

import java.util.ArrayList;
import java.util.List;

public class JMoney {

    private final Integer amount;
    private final String currency;

    public JMoney(Integer amount, String currency) {
        this.amount = amount;
        this.currency = currency;

    }
    public JMoney(String currency) {
        this(0,"USD");
    }
    public JMoney(Integer amount) {
        this(amount,"USD");
    }

    public JMoney() {
        this(0,"USD");
    }

    public Integer getAmount() {
        List<Integer> x = new ArrayList<Integer>();
        x.add(4);
        x.add(6);

        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.amount != null ? this.amount.hashCode() : 0);
        hash = 29 * hash + (this.currency != null ? this.currency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final JMoney other = (JMoney) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + ", currency=" + currency + '}';

    }
}