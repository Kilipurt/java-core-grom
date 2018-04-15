package lesson26.homework;

import java.util.ArrayList;

public class ArrayListTest {

    public static ArrayList<Order> useList() {
        Order order1 = new Order(1, 1, "USD", "chair", "shop");
        Order order2 = new Order(2, 2, "USD", "chair", "shop");
        Order order3 = new Order(3, 3, "USD", "chair", "shop");
        Order order4 = new Order(4, 4, "USD", "chair", "shop");
        Order order5 = new Order(5, 5, "USD", "chair", "shop");

        ArrayList<Order> list = new ArrayList<>();

        list.add(order1);
        list.add(order2);
        list.add(order3);

        list.add(1, order1);
        list.add(0, order1);

        list.remove(order1);

        list.remove(1);

        ArrayList<Order> list1 = new ArrayList<>();

        list1.add(order4);
        list1.add(order5);

        list.addAll(list1);

        list.subList(0, 1);

        list.set(0, order5);

        System.out.println(list.contains(order1));

        list.toArray();

        list1.clear();

        System.out.println(list.size());

        return list;
    }
}
