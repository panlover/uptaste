package cn.uptaste.service;

import cn.uptaste.model.Category;
import cn.uptaste.model.Merchant;
import cn.uptaste.model.Product;
import cn.uptaste.model.Shop;

/**
 * Created by yudeyang on 14-2-21.
 */
public interface MerchantService {

    public void addCategory(Category category);

    public void addProduct(Product product);

    Merchant getMerchantByUsernameAndPassword(String username, String password);

    Merchant getMerchantByUsername(String username);

    void addMerchant(Merchant merchant);

    void addShop(Shop shop);

    Shop getShopById(Long aLong);

    Category getCategoryById(Long id);

    Product getProductById(Long id);
}
