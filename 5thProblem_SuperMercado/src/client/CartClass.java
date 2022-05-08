package client;

import items.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class CartClass implements Cart {
    // Instance variables
    private String id;
    private int maxLoad;
    private ArrayList<Item> items;

    public CartClass(String id, int maxLoad) {
        this.id = id;
        this.maxLoad = maxLoad;
        items = new ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public boolean isItemInCart(Item item) {
        return items.contains(item);
    }

    @Override
    public int emptyCart() {
        Iterator<Item> itemsIt = items.listIterator();
        int sumPrices = 0;

        while (itemsIt.hasNext()) {
            sumPrices += itemsIt.next().getPrice();
        }
        items.clear();

        return sumPrices;
    }

    @Override
    public boolean isCartEmpty() {
        return items.size() > 0;
    }

    @Override
    public boolean isCartOverloaded(Item item) {
        Iterator<Item> itemsIt = items.listIterator();
        int sumLoad = 0;

        while (itemsIt.hasNext()) {
            sumLoad += itemsIt.next().getVolume();
        }

        return sumLoad + item.getVolume() >= maxLoad;
    }

    @Override
    public ListIterator<Item> listItemsInCart() {
        return items.listIterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Cart)
            return this.getId().equals(((Cart) other).getId());
        else
            return false;
    }
}
