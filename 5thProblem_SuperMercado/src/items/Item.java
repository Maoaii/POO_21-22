package items;

public interface Item extends Comparable<Item> {

    String getName();

    int getVolume();

    int getPrice();

    boolean equals(Object other);

    int compareTo(Item other);
}
