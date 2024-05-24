import classes.Product;
import classes.Basket;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Product prod1 = new Product("apple", 50);
        Product prod2 = new Product("bread", 40);
        Product prod3 = new Product("chips", 150);
        Product prod4 = new Product("milk", 70);
        Product prod5 = new Product("house", 5000000);
        Product prod6 = new Product("helicopter", 192000000);
        Product prod7 = new Product("cat", 5000);
        basket.addProduct(prod1);
        basket.addProduct(prod2);
        basket.addProduct(prod3);
        basket.addProduct(prod4);
        basket.addProduct(prod5);
        basket.addProduct(prod6);
        basket.addProduct(prod7);
        basket.sellProduct(prod7);
        System.out.println("Number of products in basket " + basket.getProductsInBasket());
        System.out.println("Number of products sold " + basket.getProductsSold());
        System.out.println("Price of products sold " + basket.getPriceProductsSold());
        System.out.println("Price of products in basket " + basket.getPriceProductsInBasket());
        System.out.println("Product with index 6 " + basket.getProductAtIndex(6));
    }
}