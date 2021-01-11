package it.academy.data;

import java.util.Date;
import java.util.Objects;

public class Expenses {

    private int num;
    private Date payDate;
    private double payValue;
    private String receiverName;

    public Expenses() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public double getPayValue() {
        return payValue;
    }

    public void setPayValue(double payValue) {
        this.payValue = payValue;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return num == expenses.num &&
                Double.compare(expenses.payValue, payValue) == 0 &&
                Objects.equals(payDate, expenses.payDate) &&
                Objects.equals(receiverName, expenses.receiverName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, payDate, payValue, receiverName);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "num=" + num +
                ", payDate=" + payDate +
                ", payValue=" + payValue +
                ", receiverName='" + receiverName + '\'' +
                '}';
    }
}
