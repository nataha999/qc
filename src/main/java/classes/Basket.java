package classes;

import java.util.ArrayList;

public class Basket {
    public ArrayList<Product> productsInBasket = new ArrayList<>();
    public ArrayList<Product> productsSold = new ArrayList<>();

    public Product getProductAtIndex(int index)
    {
        if (index < productsInBasket.size())
        {
            return productsInBasket.get(index);
        }
        return new Product("", 0);
    }

    public int getPriceProductsInBasket()
    {
        int sum = 0;

        if (productsInBasket.isEmpty())
        {
            return 0;
        }

        for (Product product : productsInBasket)
        {
            sum += product.getPrice();
        }
        return sum;
    }

    public int getPriceProductsSold()
    {
        int sum = 0;

        for (Product product : productsSold)
        {
            sum += product.getPrice();
        }
        return sum;
    }

    public int getProductsInBasket()
    {
        return productsInBasket.size();
    }

    public int getProductsSold()
    {
        return productsSold.size();
    }

    public void addProduct(Product product)
    {
        productsInBasket.add(product);
    }

    public void sellProduct(Product product)
    {
        for (Product prod : productsInBasket)
        {
            if (product.getId() == prod.getId())
            {
                productsInBasket.remove(prod);
                productsSold.add(prod);
                break;
            }
        }
    }
}
