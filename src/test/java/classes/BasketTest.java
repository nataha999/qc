package classes;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BasketTest {
    @Mock
    Product product;

    Basket basket = new Basket();

    @Test
    public void empty_sold()
    {
        int price = basket.getPriceProductsSold();

        assertEquals("no items sold", 0, price);
    }

    @Test
    public void get_number_of_products_in_empty_basket()
    {
        int products = basket.getProductsInBasket();

        assertEquals("wrong quantity of products", 0, products);
    }

    @Test
    public void get_number_of_products_in_not_empty_basket()
    {
        getProduct();

        int products = basket.getProductsInBasket();

        assertEquals("wrong quantity of products", 9, products);
    }

    @Test
    public void get_price_products_in_empty_basket()
    {
        int price = basket.getPriceProductsInBasket();

        assertEquals("wrong quantity of price", 0, price);
    }

    @Test
    public void get_price_products_in_basket()
    {
        getProduct();

        Mockito.when(product.getPrice()).thenReturn(1);
        int price = basket.getPriceProductsInBasket();

        assertEquals("wrong quantity of price", 9, price);
    }

    @Test
    public void get_product_with_incorrect_index()
    {
        String name = basket.getProductAtIndex(100).getName();
        int price = basket.getProductAtIndex(100).getPrice();

        assertEquals("wrong product name", "", name);
        assertEquals("wrong product price", 0, price);
    }

    @Test
    public void get_product_with_correct_index()
    {
        getProduct();

        Mockito.when(product.getPrice()).thenReturn(50);
        Mockito.when(product.getName()).thenReturn("apple");

        String name = basket.getProductAtIndex(0).getName();
        int price = basket.getProductAtIndex(0).getPrice();

        assertEquals("incorrect product name","apple", name);
        assertEquals("incorrect product price", 50, price);
    }

    @Test
    public void sale_non_existent_product()
    {
        basket.sellProduct(basket.getProductAtIndex(0));
        int soldProducts = basket.getProductsSold();

        assertEquals("wrong amount of sold products", 0, soldProducts);
    }

    @Test
    public void sale_existing_product()
    {
        getProduct();

        basket.sellProduct(basket.getProductAtIndex(0));
        int soldProducts = basket.getProductsSold();

        assertEquals("wrong amount of sold products", 1, soldProducts);
    }

    @Test
    public void sell_two_existing_products_of_the_same_index()
    {
        getProduct();

        basket.sellProduct(basket.getProductAtIndex(0));
        basket.sellProduct(basket.getProductAtIndex(0));
        int soldProducts = basket.getProductsSold();

        assertEquals("wrong amount of sold products", 2, soldProducts);
    }

    @Test
    public void verification_number_of_products_after_the_sale_of_one()
    {
        getProduct();

        basket.sellProduct(basket.getProductAtIndex(0));
        int productsOnBasket = basket.getProductsInBasket();

        assertEquals("wrong amount of sold products", 8, productsOnBasket);
    }

    @Test
    public void get_price_products_in_sold()
    {
        getProduct();

        basket.sellProduct(basket.getProductAtIndex(0));
        int price = basket.getPriceProductsSold();

        assertEquals("wrong quantity of price", 0, price);
    }

    @Test
    public void add_product_in_empty_basket()
    {
        basket.addProduct(product);

        assertEquals("wrong quantity of products", 1, basket.getProductsInBasket());
    }

    @Test
    public void add_and_sell_product()
    {
        basket.addProduct(product);
        basket.sellProduct(basket.getProductAtIndex(0));

        assertEquals("wrong quantity of products", 0, basket.getProductsInBasket());
    }

    @Test
    public void add_product_in_non_empty_basket()
    {
        getProduct();
        basket.addProduct(product);

        int productInBasket = basket.getProductsInBasket();

        assertEquals("wrong quantity of products", 10, productInBasket);
    }

    void getProduct() {
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
        basket.addProduct(product);
    }
}
