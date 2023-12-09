package Topic_4.hw_10;

/**
 * Task_8_1
 * @author Holopura Anna
 */

import java.util.ArrayList;
import java.util.List;

public class Payment
{
    private List<Item> items;

    public Payment()
    {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity)
    {
        Item item = new Item(name, price, quantity);
        items.add(item);
    }

    public double totalPrice()
    {
        double total = 0;
        for (Item item : items)
        {
            total += item.totalPrice();
        }
        return total;
    }

    public void printPayment()
    {
        System.out.println("Payment");
        for (Item item : items)
        {
            System.out.println(item.toString());
        }
        System.out.println("Total price: " + totalPrice() + "$");
    }

    private class Item
    {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity)
        {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double totalPrice() { return price * quantity; }

        @Override
        public String toString()
        {
            return "Item: " + name + ", Price: " + price + "$, Quantity: " + quantity + ", Total: " + totalPrice() + "$";
        }
    }

    public static void main(String[] args)
    {
        Payment payment = new Payment();

        payment.addItem("jacket", 29.50, 1);
        payment.addItem("blouse", 7.05, 3);
        payment.addItem("jeans", 13.75, 2);

        payment.printPayment();
    }
}
