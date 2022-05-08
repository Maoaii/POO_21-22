package items;

public class ItemClass implements Item{
    // Instance variables
    private String name;
    private int price;
    private int volume;

    public ItemClass(String name, int price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Item)
            return this.getName().equals(((Item) other).getName());
        else
            return false;
    }

    @Override
    public int compareTo(Item other) {
        return this.getName().compareTo(other.getName());
    }
}
