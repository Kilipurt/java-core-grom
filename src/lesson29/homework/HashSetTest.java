package lesson29.homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

    public static Set<Order> useHashSet() {
        Order order1 = new Order(1, 1, "USD", "chair", "shop");
        Order order2 = new Order(2, 2, "USD", "chair", "shop");
        Order order3 = new Order(3, 3, "USD", "chair", "shop");
        Order order4 = new Order(4, 4, "USD", "chair", "shop");
        Order order5 = new Order(5, 5, "USD", "chair", "shop");

        Set<Order> orders1 = new HashSet<>();

        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order3);

        Set<Order> orders2 = new HashSet<>();

        orders2.add(order2);
        orders2.add(order3);
        orders2.add(order4);

        orders1.retainAll(orders2);

        orders1.remove(order2);

        orders1.add(order1);
        orders1.add(order2);
        orders1.add(order4);
        orders1.add(order5);

        Object[] array = orders1.toArray();

        System.out.println(orders1.size());

        Iterator<Order> orderIterator = orders1.iterator();

        while (orderIterator.hasNext()) {
            System.out.println(orderIterator.next());
        }

        return orders1;
    }
}
