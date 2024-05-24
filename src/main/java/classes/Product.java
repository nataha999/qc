package classes;

public class Product {
    public String name;
    public int price;
    public double id;

    public Product(String name, int price) {
        this.name = name;
        this.price = Math.max(price, 0);
        this.id = (int) (Math.random() * 10000);
    }

    public int getPrice()
    {
        return this.price;
    }
    public String getName()
    {
        return this.name;
    }
    public double getId()
    {
        return this.id;
    }
}
