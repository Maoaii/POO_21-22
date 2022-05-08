package groceryStoreSystem;

import client.Cart;
import client.CartClass;
import items.Item;
import items.ItemClass;

import java.util.ArrayList;
import java.util.Iterator;

public class GroceryStoreSystemClass implements GroceryStoreSystem{
    // Instance variables
    private ArrayList<Cart> carts;
    private ArrayList<Item> items;

    public GroceryStoreSystemClass() {
        carts = new ArrayList<>();
        items = new ArrayList<>();
    }

    @Override
    public void addCart(String id, int maxLoad) {
        carts.add(new CartClass(id, maxLoad));
    }

    @Override
    public boolean isCartRegistered(String id) {
        return carts.contains(new CartClass(id, 0));
    }

    @Override
    public void createItem(String name, int price, int volume) {
        items.add(new ItemClass(name, price, volume));
    }

    @Override
    public boolean isItemRegistered(String name) {
        return items.contains(new ItemClass(name, 0, 0));
    }

    @Override
    public void addItemToCart(String itemName, String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));
        Item item = items.get(items.indexOf(new ItemClass(itemName, 0, 0)));

        cart.addItem(item);
    }

    @Override
    public boolean isCartOverloaded(String itemName, String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));
        Item item = items.get(items.indexOf(new ItemClass(itemName, 0, 0)));

        return cart.isCartOverloaded(item);
    }

    @Override
    public void removeItemFromCart(String itemName, String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));
        Item item = items.get(items.indexOf(new ItemClass(itemName, 0, 0)));

        cart.removeItem(item);
    }

    @Override
    public boolean isItemInCart(String itemName, String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));
        Item item = items.get(items.indexOf(new ItemClass(itemName, 0, 0)));

        return cart.isItemInCart(item);
    }

    @Override
    public Iterator<Item> listItemsFromCart(String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));

        return cart.listItemsInCart();
    }

    @Override
    public boolean isCartEmpty(String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));

        return cart.isCartEmpty();
    }



    @Override
    public int payCart(String cartId) {
        Cart cart = carts.get(carts.indexOf(new CartClass(cartId, 0)));

        return cart.emptyCart();
    }
}
