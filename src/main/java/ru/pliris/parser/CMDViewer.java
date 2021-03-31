package ru.pliris.parser;

public class CMDViewer implements Viewer{
    private Operations operations;

    public CMDViewer(Operations operations) {
        this.operations = operations;
    }

    @Override
    public void viewTotalAmountSupplier() {
        System.out.println("Общая сумма долга перед поставщиком " + operations.getTotalAmountSupplier() + System.lineSeparator());
    }

    @Override
    public void viewTotalPrepayment() {
        System.out.println("Общая сумма внесенных авансов " + operations.getTotalPrepayment() + System.lineSeparator());
    }

    @Override
    public void viewTotalAmountDialer() {
            System.out.println("Общая сумма дохода дилера " + operations.getTotalAmountDialer() + System.lineSeparator());
    }
    @Override
    public void viewTotal() {
        System.out.println("Общая сумма заказов в розничных ценах " + operations.getTotal() + System.lineSeparator());
    }

    @Override
    public void viewTotalIncome() {
        System.out.println("Общая сумма к доплате при доставке " + operations.getTotalIncome() + System.lineSeparator());
    }


}
