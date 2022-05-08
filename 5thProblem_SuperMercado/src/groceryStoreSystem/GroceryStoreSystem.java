package groceryStoreSystem;

import items.Item;

import java.util.Iterator;

public interface GroceryStoreSystem {

    void addCart(String id, int maxLoad);

    boolean isCartRegistered(String id);

    void createItem(String name, int price, int volume);

    boolean isItemRegistered(String name);

    void addItemToCart(String itemName, String cartId);

    boolean isCartOverloaded(String itemName, String cartId);

    void removeItemFromCart(String itemName, String cartId);

    boolean isItemInCart(String itemName, String cartId);

    Iterator<Item> listItemsFromCart(String cartId);

    boolean isCartEmpty(String cartId);

    int payCart(String cartId);
}
