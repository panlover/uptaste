package cn.uptaste.common.shopping;

import cn.uptaste.common.exception.ShopException;
import cn.uptaste.model.Product;
import org.springframework.util.NumberUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 * Created by yudeyang on 14-2-21.
 */
public class ShoppingCart {

    private BigDecimal price=BigDecimal.ZERO;
    
    private List<ShoppingCartItem> shoppingCartItems;

    /**
     * 得到购物栏中的所有价格
     * @return
     */
    public Double getTotalPrize(){
        if (shoppingCartItems == null) {
            return price.doubleValue();
        }
        for (ShoppingCartItem cartItem : shoppingCartItems) {
            price.add(cartItem.getPrice());
        }
        return price.doubleValue();
    }

    public String getTextFormatTotalPrice(){
        if (shoppingCartItems == null) {
            return price.toPlainString();
        }
        for (ShoppingCartItem cartItem : shoppingCartItems) {
            price.add(cartItem.getPrice());
        }
        return price.toPlainString();
    }

    /**
     * 添加商品到购物车，分为以下情况：
     * 已经存在：增加指定的数量，如果增加后数量小于0，则删除该商品
     * 不存在：添加指定的产品
     * 如果amount为0的话，意味着删除相关产品
     * @param product
     * @param amount
     * @throws ShopException
     */
    public void addToCart(Product product,int amount){
        List<ShoppingCartItem> anotherItemList=new ArrayList<ShoppingCartItem>();
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            if (shoppingCartItem.getProduct().getId().equals(product.getId())){
                /*对购物车中的物品和数量进行处理*/
                if(amount!=0){
                    if ((shoppingCartItem.getAmount()+amount)>=0){
                        ShoppingCartItem cartItem=new ShoppingCartItem(product,shoppingCartItem.getAmount()+amount);
                        anotherItemList.add(cartItem);
                    }
                }
            }else{
                if (amount>0){
                    ShoppingCartItem cartItem=new ShoppingCartItem(product,amount);
                    anotherItemList.add(cartItem);
                }
            }
        }
        this.shoppingCartItems=anotherItemList;
    }
}
