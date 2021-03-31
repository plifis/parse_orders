package ru.pliris.parser;

import ru.pliris.order.Order;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface Parse {
    public List<Order> list(String link) throws IOException, ParseException;
}
