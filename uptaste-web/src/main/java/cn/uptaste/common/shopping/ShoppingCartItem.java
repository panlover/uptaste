package cn.uptaste.common.shopping;

import cn.uptaste.model.Product;

import java.math.BigDecimal;

/**
 * 购物车中的商品条目，包括商品和数量
 * Created by yudeyang on 14-2-22.
 */
public class ShoppingCartItem {
    private Product product;
    private int amount;

    public ShoppingCartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * 返回这个条目的价格
     * @return
     */
    public BigDecimal getPrice(){
        return product.getPrice().multiply(new BigDecimal(amount));
    }
}
