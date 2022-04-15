package com.java.university;

import java.io.Serializable;
import java.util.Objects;

public class Check implements Serializable {

    private String cardNumber;

    private Long money;

    private boolean status;


    public Check(String cardNumber, Long money, boolean status) {
        this.cardNumber = cardNumber;
        this.money = money;
        this.status = status;
    }

    public Check() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Long getMoney() {
        return money;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return status == check.status && Objects.equals(cardNumber, check.cardNumber) && Objects.equals(money, check.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, money, status);
    }

    @Override
    public String toString() {
        return "Check{" +
                "cardNumber='" + cardNumber + '\'' +
                ", money=" + money +
                ", status=" + status +
                '}';
    }


}
