package cn.uptaste.repository;

import cn.uptaste.model.Shop;

/**
 * Created by yudeyang on 14-2-21.
 */
public interface ShopRepository {

    public void addShop(Shop shop);

    Shop getShopById(Long id);
}
