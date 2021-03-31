package ru.pliris.parser;

import ru.pliris.order.Order;
import java.util.List;

public interface Store {
    public void save(Order order);
    public List<Order> getAll();
}
