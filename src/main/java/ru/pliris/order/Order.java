package ru.pliris.order;

import java.util.Date;

public class Order {
    private Integer number; // номер заказа
    private Date dateOrder; // дата заказа
    private Date dateDelivery; // дата доставки
    private String name; // имя заказчика (розничного покупателя)
    private Integer prepayment; // принятый аванс
    private Integer amountSupplier; // сумма поставщика
    private Integer amountDialer; // сумма дилера
    private Integer total; // сумма в розничной цене
    private Integer income; // сумма доплаты при доставке
    private Double volume; // объем заказа
    private Double weight; // вес заказа
    private String status; // статус заказа


    public Order(Integer number, Date dateOrder, Date dateDelivery, String name,
                 Integer prepayment, Integer amountSupplier, Integer amountDialer,
                 Integer total, Integer income, Double volume, Double weight, String status) {
        this.number = number;
        this.dateOrder = dateOrder;
        this.dateDelivery = dateDelivery;
        this.name = name;
        this.prepayment = prepayment;
        this.amountSupplier = amountSupplier;
        this.amountDialer = amountDialer;
        this.total = total;
        this.income = income;
        this.volume = volume;
        this.weight = weight;
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(Integer prepayment) {
        this.prepayment = prepayment;
    }

    public Integer getAmountSupplier() {
        return amountSupplier;
    }

    public void setAmountSupplier(Integer amountSupplier) {
        this.amountSupplier = amountSupplier;
    }

    public Integer getAmountDialer() {
        return amountDialer;
    }

    public void setAmountDialer(Integer amountDialer) {
        this.amountDialer = amountDialer;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
