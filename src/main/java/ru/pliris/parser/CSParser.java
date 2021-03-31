package ru.pliris.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.pliris.order.Order;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CSParser implements Parse {


    /**
     * Возвращает объект класса Order на основе парсинга
     * @param descriptions список элементов спарсенной страницы для создания объекта Order
     * @param i индекс элемента, который требуется для создания объекта Order
     * @return объект Order
     * @throws ParseException исключения, возникает при невозможности парсинга элемента
     */
    private Order getOrder(Elements descriptions, int i) throws ParseException {
            Attributes attr = descriptions.get(i).attributes();
            Integer number = Integer.valueOf(attr.get("data-id"));
            Integer amountSupplier = Integer.valueOf(attr.get("data-dil-sum"));
            Double volume = Double.valueOf(attr.get("data-kub-sum"));
            Integer total = Integer.valueOf(attr.get("data-rozn-sum"));
            String status = attr.get("data-type");
            Double weight = Double.valueOf(attr.get("data-weight-sum"));
            String dateDelivery = descriptions.get(i).child(3).text();
            String dateOrder = descriptions.get(i).child(4).text();
            String name = descriptions.get(i).child(5).text();
            String strPrepayment = descriptions.get(i).child(6).text();
            String strAmountDialer = descriptions.get(i).child(9).text();
            String strIncome = descriptions.get(i).child(11).text();
            return new Order(number, this.convertDate(dateOrder), this.convertDate(dateDelivery),
                    name, this.getPrepayment(strPrepayment), amountSupplier, this.getAmountDialer(strAmountDialer),
                    total, this.getIncome(strIncome), volume, weight, status);
    }

    /**
     * Возвращает аванс в виде примитива int, если строка не пустая
     * @param str строка из которой требуется получить цифровое значение
     * @return аванс, если строка была заполнена, иначе 0
     */
    private int getPrepayment(String str) {
        int prepayment = 0;
        if (str.contains(" ")) {
            return prepayment = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
        }
        return prepayment = Integer.parseInt(str);
    }

    /**
     * Возвращает сумму (доход) дилера по данному заказу в виде примитива int, если строка не пустая
     * @param str строка из которой требуется получить цифровое значение
     * @return доход дилера, если строка не пустая, иначе 0
     */
    private int getAmountDialer(String str) {
        int amount = 0;
        if (!str.isEmpty()) {
            amount = Integer.parseInt(str);
        }
        return amount;
    }

    /**
     * Возращает размер доплаты на адресе по данному заказу в виде примитива int, если строка не пустая
     * @param strIncome строка из которой требуется получить цифровое значение
     * @return размер доплаты, если стркоа не пустая, иначе 0
     */
    private int getIncome(String strIncome) {
        int startStr;
        int endStr;
        int income = 0;
        if (strIncome.contains("доплата")) {
            startStr = strIncome.lastIndexOf("доплата ");
            endStr = strIncome.indexOf(" руб");
            income = Integer.parseInt(strIncome.substring(startStr + 8, endStr));
        }
        return income;
    }

    /**
     * Возращает дату в формате "ДД.ММ.ГГГГ" из переданной строки
     * @param strDate строка из которой требуется получить дату
     * @return дата
     * @throws ParseException исключения, возникает при невозможности парсинга строки
     */
    private Date convertDate(String strDate) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.parse(strDate);
    }

    /**
     * Возвращает список всех заказов в виде объектов класса Order с указанной страницы
     * @param link ссылка на страницу, в данном случае страница предсталвяет собой файл
     * @return список всех заказов на странице
     * @throws IOException исключение возникает при ошибке чтения файла
     * @throws ParseException исключения возникает при невозмоности парсинга страницы (её элементов)
     */
    @Override
    public List<Order> list(String link) throws IOException, ParseException {
        List<Order> list = new ArrayList<>();
        File file = new File(link);
        Document document = Jsoup.parse(file, "UTF-8");
        Elements descriptions = document.select("[data-actual=1]");
        for (int i = 0; i < descriptions.size(); i++) {
            list.add(this.getOrder(descriptions, i));
        }
        return list;
    }

}




