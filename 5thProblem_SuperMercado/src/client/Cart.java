package client;

import items.Item;

import java.util.ListIterator;

public interface Cart {

    String getId();

    void addItem(Item item);

    void removeItem(Item item);

    boolean isItemInCart(Item item);

    int emptyCart();

    boolean isCartEmpty();

    boolean isCartOverloaded(Item item);

    ListIterator<Item> listItemsInCart();

    boolean equals(Object other);
}
