package ru.pliris.parser;

import ru.pliris.order.Order;

import java.util.List;
import java.util.function.Function;

public class OperationsMoney implements Operations {
    private List<Order> list;

    public OperationsMoney(List<Order> list) {
        this.list = list;
    }

    /**
     * Возвращает общую сумму денежных средств за отгрузки постащика (долг дилера перед поставщиком)
     * @return сумму денежных средств за отгрузки постащика (долг дилера по всем заказам)
     */
    @Override
    public int getTotalAmountSupplier() {
        Function<Order, Integer> supplier = order -> order.getAmountSupplier();
    return this.getOverall(supplier);
    }

    /**
     * Возвращает общую сумму принятой предоплаты (аванса) по всем заказам
     * @return сумма принятой предоплаты
     */
    @Override
    public int getTotalPrepayment() {
        Function<Order, Integer> prepayment = order -> order.getPrepayment();
        return this.getOverall(prepayment);
    }

    /**
     * Возвращает общую сумму дохода дилера
     * @return сумма дохода дилера (розничного продавца)
     */
    @Override
    public int getTotalAmountDialer() {
        Function<Order, Integer> dialer = order -> order.getAmountDialer();
        return this.getOverall(dialer);
    }

    /**
     * Возвращает общую сумму заказов (в розничных ценах)
     * @return сумма заказов в розничных ценах
     */
    @Override
    public int getTotal() {
        Function<Order, Integer> total = order -> order.getTotal();
        return this.getOverall(total);
    }

    /**
     * Возвращает общую сумму к доплате при доставке
     * @return сумма доплат при доставке
     */
    @Override
    public int getTotalIncome() {
        Function<Order, Integer> income = order -> order.getIncome();
        return this.getOverall(income);
    }

    /**
     * Метод возращает сумму указанного поля всех объектов
     * @param function поле по которому считаем сумму
     * @return сумма для указанного поля
     */
    private int getOverall(Function<Order, Integer> function) {
        int sum = 0;
        for (Order order : list) {
            sum = sum + function.apply(order);
        }
        return sum;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }


}
