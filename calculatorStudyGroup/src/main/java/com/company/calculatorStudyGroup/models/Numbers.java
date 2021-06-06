package com.company.calculatorStudyGroup.models;

import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Numbers {

    @NotNull
    private Double num1;
    @NotNull
    private Double num2;

    public Numbers(Double num1, Double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Numbers() {

    }

    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(getNum1(), numbers.getNum1()) && Objects.equals(getNum2(), numbers.getNum2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNum1(), getNum2());
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
